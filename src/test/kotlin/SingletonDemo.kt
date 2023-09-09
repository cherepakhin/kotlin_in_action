import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
Встроен прямо в язык в виде ключевого слова OBJECT:
Инициализируется лениво, т.е. будет нициализировано НЕ ПРИ ЗАГРУЗКЕ, а при ПЕРВОМ обращении
 */

object JustSingleton {
    // Теперь поле JustSingleton.value будет доступно из любого места в пакете.
    val value : String = "Just a value"
}

class JustSingletonTest {
    @Test
    fun demoSingleton() {
        Assertions.assertEquals("Just a value", JustSingleton.value)
    }

}
