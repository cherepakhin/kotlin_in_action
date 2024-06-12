import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingletonWithObjectTest {
    object Singleton {
        // call as STATIC method: Singleton.methodObj()
        fun methodObj(): String {
            return "from methodObj";
        }
    }

    @Test
    fun test() {
        assertEquals("from methodObj", Singleton.methodObj())
    }

    @Test
    fun useSingletonInObjectTest() {
        class ObjectWithSingleton {
            val singleton = Singleton
        }

        val objectWithSingleton = ObjectWithSingleton()
        assertEquals("from methodObj", objectWithSingleton.singleton.methodObj())
    }
}