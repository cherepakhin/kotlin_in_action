import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LabelTest {
    @Test
    internal fun simple() {
        var count = 0
        myloop@ for (i in 1..100) {
            for (j in 1..100) {
                if (i == 3) break@myloop
                count++
            }
        }
        Assertions.assertEquals(200, count)
    }
}