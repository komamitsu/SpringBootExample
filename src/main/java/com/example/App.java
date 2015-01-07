package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @Bean
    HttpMessageConverter httpYamlJackson2MessageConverter() {
        return new AbstractJackson2HttpMessageConverter(
                new ObjectMapper(new YAMLFactory()) /* change here */,
                new MediaType("application", "x-yaml")) {
        };
    }


    @Bean
    HttpMessageConverter httpSmileJackson2MessageConverter() {
        return new AbstractJackson2HttpMessageConverter(
                new ObjectMapper(new SmileFactory()) /* change here */,
                new MediaType("application", "x-smile")) {
        };
    }

    @Bean
    HttpMessageConverter httpMsgpackJackson2MessageConverter() {
        return new AbstractJackson2HttpMessageConverter(
                new ObjectMapper(new MessagePackFactory()) /* change here */,
                new MediaType("application", "x-msgpack")) {
        };
    }

    static class Result {
        private final int left;
        private final int right;
        private final long answer;

        Result(int left, int right, long answer) {
            this.left = left;
            this.right = right;
            this.answer = answer;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public long getAnswer() {
            return answer;
        }
    }

    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        return new Result(left, right, left + right);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
