import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.base.O

class ImmutableTest {

    @Test
    fun compareListStrings() {
        val immutableList = listOf("one", "two")
        var s = immutableList[0] // строки копируются
        s = "S"
        assertEquals(listOf("one", "two"), immutableList)
    }

    @Test
    fun compareListObjects() {
        val o1 = O()
        o1.setProp("o")
        val o2 = O()
        o2.setProp("o")

        assertEquals(o1, o2)

        val list1 = listOf<O>(o1, o1)
        val list2 = listOf<O>(o2, o2)

        // EQUALS! Сравниваются значения в list, несмотря на то , что ОЪЕКТЫ(адреса) list разные!
        // и экземпляры объектов разные (но у них одинаковые значения)
        // т.о. List-ы сравниваются правильно и тщательно
        // Переопределение equals, hashCode в O.kt обязательно!!!
        assertEquals(list1, list2)
    }
}