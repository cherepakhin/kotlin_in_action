package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ArrTest {

    @Test
    internal fun getByIndex() {
        // listOf = неизменяемый. Нельзя добавить элементы. Изменяемый arrayListOf()
        val list = listOf("aaa", "bbb")
//        list.add() - нет такого метода, т.к. неизменяемый
        Assertions.assertEquals("aaa", list[0])
        Assertions.assertEquals("aaa", list.get(0))
    }

    @Test
    internal fun addToList() {
        // val - неизменяемое. Нельзя изменить ссылку,
        val list = arrayListOf("aaa", "bbb")
        // но добавить элемент можно, т.к. arrayListOf позволяет добавлять, в отличие от listOf
        list.add("ccc")
        Assertions.assertEquals("ccc", list.get(2))
    }
    @Test
    internal fun unmuttableToMuttable() {
        // почти тоже самое, что и тест выше addToList()
        // val - неизменяемое. Нельзя изменить ссылку,
        // но добавить элемент можно

        // "listOf" - UNMUTTABLE. Нельзя добавлять/удалять. ERROR myUnmutableList.add()
        // в общем, константная константа. НИЧЕГО БОЛЬШЕ НЕЛЬЗЯ
        val myUnmutableList = listOf<String>("aaa")
        // и ссылку myUnmutableList менять нельзя (VAL!). ERROR при myUnmutableList = listOf()

        // "arrayListOf" - MUTTABLE. Можно добавлять/удалять
        val myMutableList = arrayListOf<String>()

        // Можно добавлять/удалять, но переопределять ссылку нельзя , т.к. VAL
        // myMutableList = arrayListOf<String>()

        myMutableList.addAll(myUnmutableList) // так сделать изменяемым
        myMutableList.add("ccc")
        myMutableList.add("ddd")
        Assertions.assertEquals("aaa", myMutableList.get(0))
        Assertions.assertEquals("ddd", myMutableList.get(2))

        myMutableList.set(0, "0000")
        Assertions.assertEquals("0000", myMutableList.get(0))
        var elem = myMutableList.get(0)
        elem = "2222"
        // значение в myMutableList[0] не изменилось. Строка по значению передалась.
        // С объектом Д.Б. не так. См.ниже unmuttableToMuttableForObject()
        Assertions.assertEquals("0000", myMutableList.get(0))
    }

    @Test
    internal fun unmuttableToMuttableForObject() {
        class MyStr {
            var s = "" // желательно все-таки тип указывать  s:String

            constructor(s: String) {
                this.s = s
            }
        }
        val myUnmutableList = listOf<MyStr>(MyStr("1"), MyStr("2"))
        myUnmutableList.get(1).s = "----"
        Assertions.assertEquals("----", myUnmutableList.get(1).s)
    }
}