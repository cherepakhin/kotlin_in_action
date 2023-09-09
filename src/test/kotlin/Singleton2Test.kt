import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
Singleton встроен прямо в язык в виде ключевого слова OBJECT:
Инициализируется лениво при ПЕРВОМ обращении(НЕ ПРИ ЗАГРУЗКЕ)
STATIC в Kotlin нет, поэтому такой прием с ключевым словом "object"
*/
object SlowSingleton {
    val value: String

    init {
        var uuid = ""
        // total - затраченное время в мс
        val elapsedTimeMills = measureTimeMillis { // measureTimeMillis меряет время в миллисекундах.
            println("Computing")
            for (i in 1..10_000_000) {
                uuid = UUID.randomUUID().toString()
            }
        }
        val elapsedTimeSeconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTimeMills)
        value = uuid
        println(String.format("Done computing in milliseconds: %,d", elapsedTimeMills))
        println(String.format("Done computing seconds: %,d", elapsedTimeSeconds))
    }
}

class Singleton2Test {
    @Test
    fun testSlowSingleton() {
        val duration = measureTimeMillis {
            println(SlowSingleton.value)
        }
        println(String.format("Time executed: %,d", duration))
        assertTrue(duration > 100)
    }
}