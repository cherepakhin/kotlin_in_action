import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.base.O

class ImmutableTest {

    @Test
    fun compareListStrings() {
        val immutableList = listOf("one", "two")
        var s = immutableList[0] // строки копируются
        s = "NEW_VAL"
        assertEquals(listOf("one", "two"), immutableList)
        // т.к. строки копируются, immutableList[0] остался прежним (не "NEW_VAL")
    }

    @Test
    fun compareListObjects() {
        val prevO1 = O()
        prevO1.setProp("o")
        val prevO2 = O()
        prevO2.setProp("o")

        assertEquals(prevO1, prevO2)

        val list1 = listOf<O>(prevO1, prevO1)
        val list2 = listOf<O>(prevO2, prevO2)

        // EQUALS! Сравниваются значения в list, несмотря на то , что адреса ОЪЕКТОВ в list разные!
        // и экземпляры объектов разные (но у них одинаковые значения)
        // т.о. List-ы сравниваются правильно и тщательно
        // Переопределение equals, hashCode в O.kt обязательно!!!
        assertEquals(list1, list2)
    }
}