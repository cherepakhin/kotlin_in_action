## Kotlin in action

#### Настройка

````shell
$ java -version
openjdk version "11.0.18" 2023-01-17
OpenJDK Runtime Environment (build 11.0.18+10-post-Ubuntu-0ubuntu118.04.1)
OpenJDK 64-Bit Server VM (build 11.0.18+10-post-Ubuntu-0ubuntu118.04.1, mixed mode, sharing)
````

#### Тесты

```shell
./gradlew test
```

Запуск конкретного теста из коммандной строки

```shell
./gradlew test --tests=ClassCreateTest
```

#### Запуск

```shell
./gradlew bootRun
```