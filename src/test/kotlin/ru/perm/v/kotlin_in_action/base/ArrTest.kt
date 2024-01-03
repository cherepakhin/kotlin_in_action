package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArrTest {

    @Test
    internal fun getByIndex() {
        // listOf = неизменяемый. Нельзя добавить элементы. Изменяемый arrayListOf() или mutableListOf()
        val list = listOf("aaa", "bbb")
//        list.add() - нет такого метода, т.к. неизменяемый
        assertEquals("aaa", list[0])
        assertEquals("aaa", list.get(0))
    }

    @Test
    fun checkMessageForNotExistIndex() {
        // listOf = неизменяемый. Нельзя добавить элементы. Изменяемый arrayListOf() или mutableListOf()
        val list = listOf("aaa", "bbb")
        val exception = assertThrows<Exception> {
            list.get(100000)
        }
        assertEquals("Index 100000 out of bounds for length 2", exception.message)
    }

    @Test
    internal fun addToList() {
        // val - неизменяемое. Нельзя изменить ссылку,
        val list = arrayListOf("aaa", "bbb")
        // но добавить элемент можно, т.к. arrayListOf позволяет добавлять, в отличие от listOf
        list.add("ccc")
        assertEquals("ccc", list.get(2))
    }

    @Test
    internal fun unmuttableToMuttable() {
        // почти тоже самое, что и тест выше addToList()
        // val - неизменяемое. Нельзя изменить ссылку,
        // но добавить элемент можно

        // "listOf" - UNMUTTABLE. Нельзя добавлять/удалять т.к. не arrayListOf(). ERROR on myUnmutableList.add()
        // в общем, константная константа. НИЧЕГО БОЛЬШЕ НЕЛЬЗЯ
        val myUnmutableList = listOf<String>("aaa")
        // и ссылку myUnmutableList менять нельзя (VAL!). ERROR при myUnmutableList = listOf()

        // "arrayListOf" - MUTTABLE. Можно добавлять/удалять
        val myMutableList = arrayListOf<String>()

        // Можно добавлять/удалять, но переопределять ссылку нельзя , т.к. VAL
        // myMutableList = arrayListOf<String>() //ERROR

        myMutableList.addAll(myUnmutableList) // так сделать изменяемым
        myMutableList.add("ccc")
        myMutableList.add("ddd")
        assertEquals("aaa", myMutableList.get(0))
        assertEquals("ddd", myMutableList.get(2))

        myMutableList.set(0, "0000")
        assertEquals("0000", myMutableList.get(0))
        var elem = myMutableList.get(0)
        elem = "2222"
        // значение в myMutableList[0] не изменилось. Строка передалась ПО ЗНАЧЕНИЮ.
        // С объектом НЕ ТАК, т.к. передается ссылка, не значение. См.ниже unmuttableToMuttableForObject()
        assertEquals("0000", myMutableList.get(0))
    }

    @Test
    internal fun mutableListTest() {
        val mutableList = mutableListOf<String>("aaa", "bbb")
        assertTrue(mutableList.add("ccc"))
        assertEquals(listOf("aaa", "bbb", "ccc"), mutableList)
    }

    @Test
    internal fun unmuttableToMuttableForObject() {
        class MyObj {
            var str = "" // желательно все-таки тип указывать  s:String

            constructor(s: String) { // warning. Подсказывает, что конструктор один и можно сделать проще:
                                    //        class MyObj(s: String) {
                                    //            var str = s
                                    //        }
                this.str = s
            }
        }
        // listOf - unmuttable, для изменяемого нужно использовать mutableListOf<MyObj>()
        val myUnmutableList = listOf<MyObj>(MyObj("VAL_1"), MyObj("VAL_2"))
        myUnmutableList.get(1).str = "NEW_VAL" // setStr() нет такого метода. подробности в ConstructorTest.kt
        // В myUnmutableList значение изменилось, т.к. var str,
        // объект передан по ссылке и это не примитив (String, Int и т.п.)

        // Итого: сам myUnmutableList неизменяемый,
        // myUnmutableList[0] = MyObj("1") //ERROR. Подсказывает поменять на val muttableList = mutableListOf<MyObj>()
        // но значения в объектах менять можно
        assertEquals("NEW_VAL", myUnmutableList.get(1).str)
        // val o = MyObj() нет такого конструктора
    }
}