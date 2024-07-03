import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.func.App

class AppTest {
    @Test
    fun simple() {
        val app = App()
        assertEquals("from fun1()", app.fun1())
    }

    @Test
    fun jsonSample() {
        assertEquals("from jsonSample()", App().jsonSample())
    }

    @Test
    fun asStatic() {
        assertEquals("from asStatic()", App.asStatic())
    }
}