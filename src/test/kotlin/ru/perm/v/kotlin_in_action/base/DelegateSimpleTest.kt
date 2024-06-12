package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DelegateSimpleTest {

    interface Base {
        fun printBase(): String
    }

    class BaseIntImpl(val x: Int) : Base {
        override fun printBase(): String {
            return "BaseIntImpl(x=$x)"
        }
    }

    class BaseStringImpl(val x: Int) : Base {
        override fun printBase(): String {
            return "BaseStringImpl(x=$x)"
        }
    }

    class Derived(x: Base) : Base by x //!!!! delegates to implementation Base. This is a MAIN for Delegation

    @Test
    fun test() {
        val baseIntImpl = BaseIntImpl(10)
        val derivedInt = Derived(baseIntImpl) // delegate to implementation Base ( concrete BaseImpl )
        assertEquals("BaseIntImpl(x=10)", derivedInt.printBase()) // call delegate ( baseImpl.printBase() )

        val baseStringImpl  = BaseStringImpl(10)
        val derivedString = Derived(baseStringImpl)
        assertEquals("BaseStringImpl(x=10)", derivedString.printBase())
    }
}