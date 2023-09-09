import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
Встроен прямо в язык в виде ключевого слова OBJECT:

````kotlin

object JustSingleton {
val value : String = "Just a value"
}
````

Теперь поле JustSingleton.value будет доступно из любого места в пакете.
 */

object JustSingleton {
    val value : String = "Just a value"
}

class JustSingletonTest {
    @Test
    fun demoSingleton() {
        Assertions.assertEquals("Just a value", JustSingleton.value)
    }

}
