package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimitiveTest {

    internal fun getMax(i1: Int, i2: Int): Int {
        return if (i1 > i2) i1 else i2
    }

    internal fun getMaxShort(i1: Int, i2: Int) =  if (i1 > i2) i1 else i2

    @Test
    fun maxFuncTest() {
        assertEquals(2, getMax(1,2))
    }

    @Test
    fun maxShortTest() {
        assertEquals(2, getMaxShort(1,2))
    }

    @Test
    fun castTest() {
        var i = 1
//        i ="" // Так нельзя. Тип уже присвоен как Int и Kotlin запрещает переопределить тип
        assertEquals(1, i)
    }

}