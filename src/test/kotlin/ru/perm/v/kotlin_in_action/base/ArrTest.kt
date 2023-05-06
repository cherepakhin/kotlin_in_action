package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ArrTest {

    @Test
    internal fun getByIndex() {
        // listOf = неизменяемый. Нельзя добавить элементы. Изменяемый arrayListOf()
        val list = listOf("aaa", "bbb")
        Assertions.assertEquals("aaa", list[0])
        Assertions.assertEquals("aaa", list.get(0))
    }

    @Test
    internal fun addToList() {
        val list = arrayListOf("aaa","bbb") // val - неизменяемое
        list.add("ccc")
        Assertions.assertEquals("ccc", list.get(2))
    }
}