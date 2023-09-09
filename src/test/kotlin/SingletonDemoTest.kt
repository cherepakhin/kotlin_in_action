import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
Встроен прямо в язык в виде ключевого слова OBJECT:
Инициализируется лениво, т.е. будет нициализировано НЕ ПРИ ЗАГРУЗКЕ, а при ПЕРВОМ обращении
 */

object JustSingleton {
    // Теперь поле JustSingleton.value будет доступно из любого места в пакете.
    val simpleVal : String = "Singleton value"
}

class NormalClass {
    val simpleVal : String = "Typical value"
}

class SingletonDemoTest {
    @Test
    fun useStaticSingleton() {
        // JustSingleton объявлен как "OBJECT JustSingleton" не "CLASS JustSingleton"
        // Обращение как полю класса STATIC в Java
        Assertions.assertEquals("Singleton value", JustSingleton.simpleVal)
    }

    @Test
    fun useNormalClass() {
        // А тут обращение к полю ЭКЗЕМПЛЯРА КЛАССА (экземпляр создается NormalClass() ),
        // И не к Классу, как в примере JustSingleton
        Assertions.assertEquals("Typical value", NormalClass().simpleVal)
    }
}
