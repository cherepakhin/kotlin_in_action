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

Запуск конкретного теста из командной строки

```shell
./gradlew test --tests=ClassCreateTest
```

Перезапуск тестов с очисткой

```shell
./gradlew clean test
```

#### Подключен Allure Report

Просмотр результатов:

```shell
./allure serve build/allure-results
```
Или так
```shell
./build/allure/commandline/bin/allure serve build/allure-rests/
```
Результаты тестов в Allure

![Результаты тестов в Allure](doc/allure_results.png)

#### Запуск

```shell
./gradlew bootRun
```

### Примечания

#### Делегаты в kotlin

Паттерн делегирования (Delegation) https://java-ru-blog.blogspot.com/2020/02/delegation-pattern-java.html. Это техника, в которой объект выражает определенное поведение снаружи, но в реальности делегирует ответственность за реализацию этого поведения связанному объекту. В kotlin реализовано на уровне языка ключевым словом __by__. Показано в 
[ru.perm.v.kotlin_in_action.base.DelegateCarTest](https://github.com/cherepakhin/kotlin_in_action/blob/master/src/test/kotlin/ru/perm/v/kotlin_in_action/base/DelegateCarTest.kt), [ru.perm.v.kotlin_in_action.base.DelegateSimpleTest](https://github.com/cherepakhin/kotlin_in_action/blob/master/src/test/kotlin/ru/perm/v/kotlin_in_action/base/DelegateSimpleTest.kt)
