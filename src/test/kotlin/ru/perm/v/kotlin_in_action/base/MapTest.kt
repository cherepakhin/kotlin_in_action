package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.PersonK

class MapTest {
    @Test
    internal fun simple() {
        val mutableMap = mutableMapOf<Int, PersonK>()
        // also - еще один прикол kotlin
        val person10 = PersonK(10, "name10", null).also { it.age = 10 }
        val person20 = PersonK(20, "name20", 21)
        mutableMap.put(person10.id, person10)
        mutableMap.put(person20.id, person20)

        Assertions.assertEquals(2, mutableMap.size)
        Assertions.assertEquals(person10, mutableMap.get(10))
        Assertions.assertTrue(mutableMap.containsValue(person10))

        val person30 = PersonK(30, "name30", 31)
        Assertions.assertFalse(mutableMap.values.contains(person30))
    }
}