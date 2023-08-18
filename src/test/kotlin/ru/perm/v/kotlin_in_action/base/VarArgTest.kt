package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VarArgTest {

    // vararg - переменное количество аргументов
    private fun concat(vararg strings: String): String {
        return strings.fold("") { acc, next -> "$acc$next" }
    }


    @Test
    fun simple() {
        Assertions.assertEquals("abcd", concat("ab", "cd"))
    }


    class AboutVarArgAndMuttable() {
        var size: Int = 0
//        var stringConevrtedFromVarArg: String = ""
        var stringConevrtedFromVarArg: String = ""
        var strList = listOf<String>("") // UNMUTTABLE
        val strListMuttable = mutableListOf<String>()

        constructor(vararg strings: String) : this() {
            size = strings.size // как у массива
            strList = strings.asList()

            stringConevrtedFromVarArg = strings.fold("") { acc, s -> "$acc$s" }

// Присвоить другой лист можно, т.к. var
//            strList = listOf()
// ERROR!!! listOf<String>("") is UNMUTTABLE. Добавить, НЕЛЬЗЯ для add() нужно сконвертировать .toMutableList()
//            strList.add("")

//  для add() нужно сконвертировать .toMutableList()
            val strListMuttable = strings.toMutableList() // вместо strList = strings.asList()
            strListMuttable.add("AAA")
// так не прокатывает java.lang.UnsupportedOperationException
//            var strListMuttable3 = (strList as MutableList<String>).add("AAA")
        }
    }

    @Test
    fun aboutVarArg() {
        // тут в конструкторе 2 параметра
        val aboutVarArg2 = AboutVarArgAndMuttable("var1", "var2")
        Assertions.assertEquals("var1var2", aboutVarArg2.stringConevrtedFromVarArg)
        Assertions.assertEquals(2, aboutVarArg2.size)

        // тут уже 3 параметра, а класс ТОТ ЖЕ AboutVarArg
        val aboutVarArg3 = AboutVarArgAndMuttable("var1", "var2", "var3")
        Assertions.assertEquals("var1var2var3", aboutVarArg3.stringConevrtedFromVarArg)
        Assertions.assertEquals(3, aboutVarArg3.size)

    }
}