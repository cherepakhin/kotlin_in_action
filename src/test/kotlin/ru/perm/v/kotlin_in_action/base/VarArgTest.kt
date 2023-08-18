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


    class AboutVarArg(
        var size: Int = 0,
        var stringConevrtedFromArr: String = ""
    ) {
        constructor(vararg strings: String) : this() {
            size = strings.size
            stringConevrtedFromArr = strings.fold("") { acc, s -> "$acc$s" }
        }

    }


    @Test
    fun aboutVarArg() {
        val aboutVarArg = AboutVarArg("var1", "var2")
        Assertions.assertEquals("var1var2", aboutVarArg.stringConevrtedFromArr)
    }
}