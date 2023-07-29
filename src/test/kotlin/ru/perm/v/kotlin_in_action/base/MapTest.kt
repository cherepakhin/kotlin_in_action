package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.PersonK

class MapTest {
    @Test
    internal fun simple() {
        val mutableMap = mutableMapOf<Int, PersonK>()
        val person10 = PersonK(10, "name10", 11)
        val person20 = PersonK(20, "name20", 21)
        mutableMap.put(person10.id, person10)
        mutableMap.put(person20.id, person20)
        Assertions.assertEquals(2, mutableMap.size)
        Assertions.assertEquals(person10, mutableMap.get(10))
    }
}