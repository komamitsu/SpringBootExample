# SpringBootExample
Based on http://qiita.com/making@github/items/15807d46de034409da56

## Launch this app

```
$ mvn spring-boot:run
```

## Send HTTP request

```
$ curl -v -H "Accept: application/x-yaml" "http://localhost:8080/calc?left=10&right=100"

$ curl -v -H "Accept: application/json" "http://localhost:8080/calc?left=10&right=100"

$ curl -v -H "Accept: application/x-smile" "http://localhost:8080/calc?left=10&right=100"

$ curl -v -H "Accept: application/x-msgpack" "http://localhost:8080/calc?left=10&right=100"
```

## License

Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0)
