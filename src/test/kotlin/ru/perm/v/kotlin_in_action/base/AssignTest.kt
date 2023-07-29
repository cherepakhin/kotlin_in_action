package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AssignTest {
    // Класс НЕ УКАЗАН. Определяется из контекста, присвоением ( = "" )
    var a = ""
        // set дает доступ к свойству.
        // Возможно определить какую-то сложную логику при присвоении (ниже println)
        set(value) { // сама переменная д.б. VAR! (var a). C VAL не прокатит (константа и т.п.)
            // сеттера НЕТ. вместо вызова сеттера, НУЖНО использовать '='
            println(String.format("SETTING NEW VAL for a: %s", value))
            // тут "field" ключевое слово, доступ к значению именно "a"
            field = value
        }

    @Test
    internal fun assign() {
        a = "-" // при присвоении(!) сработает сеттер (см. лог). В присвоении спрятан СЕТТЕР.
//        a = 1 //RED ERROR. Класс д.б. String, т.к. тип objectа уже определен выше в var a = ""
        Assertions.assertEquals("-", a)
    }

    @Test
    internal fun testClassB() {
        // Обычное, типичное определение класса. Не укороченное как var a.
        class B {
            private var field1 =0
            fun setField1(newVal:Int) {
                field1 = newVal
            }
            fun getField1() : Int {
                return  field1
            }
        }
        val b = B()
        b.setField1(2)
        assertEquals(2, b.getField1())
    }
}