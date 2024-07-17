package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InheritClassTest {
    open class Base { // "open" НУЖЕН для наследования
        open val name: String = "Base" // open НУЖЕН для переопределения (замена "private")
        open var var1: String = "Var1Base" // для var тоже нужно указать open
    }

    class InheritBase : Base() {
        override var var1 = "VarInheritBase" // "override" нужен для указания переопределения перменной
        // val name = "" // ERROR!!! нужно указать "override"
    }

    @Test
    fun simpleInherit() {
        val base = Base()

        assertEquals("Base", base.name)
        assertEquals("Var1Base", base.var1)

        val inheritBase = InheritBase()

        assertEquals("Base", inheritBase.name)
        assertEquals("VarInheritBase", inheritBase.var1)
    }
}