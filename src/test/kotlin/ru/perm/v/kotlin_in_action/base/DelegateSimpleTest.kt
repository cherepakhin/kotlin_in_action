package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DelegateSimpleTest {

    interface IBase {
        fun printBase(): String
    }

    class BaseIntImpl(val x: Int) : IBase {
        override fun printBase(): String {
            return "BaseIntImpl(x=$x)"
        }
    }

    class BaseStringImpl(val x: Int) : IBase {
        override fun printBase(): String {
            return "BaseStringImpl(x=$x)"
        }
    }

    //!!!! delegates to implementation Base. This is a MAIN for Delegation
    class Derived(myDelegate: IBase) : IBase by myDelegate


    @Test
    fun test() {
        val baseIntImpl = BaseIntImpl(10)
        // В определении класса Derived НЕТ РЕАЛИЗАЦИИ ФУНКЦИИ printBase() интерфейса IBase,
        // НО заявлено что он МОЖЕТ ее реализоать (т.к. IBase) (или ПРЕДПОЛОЖИМ, что он должен предоставлять такую фнкцию)
        // выражением "by ..." реализуется эта функциональность (функциональщина в полный рост!)
        // и теперь метод printBase() может быть вызван в объекте derivedInt
        val derivedInt = Derived(baseIntImpl) // delegate to BaseIntImpl
        // call delegate function BaseImpl.printBase()
        // здесь цепляется реализация из BaseIntImpl
        assertEquals("BaseIntImpl(x=10)", derivedInt.printBase())

        val baseStringImpl  = BaseStringImpl(10)
        val derivedString = Derived(baseStringImpl)
        // здесь цепляется реализация из BaseStringImpl
        assertEquals("BaseStringImpl(x=10)", derivedString.printBase())
    }
}