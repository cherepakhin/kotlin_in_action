package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PrimitiveTest {

    internal fun getMax(i1: Int, i2: Int): Int {
        return i1
    }

    @Test
    internal fun maxFuncTest() {
        Assertions.assertEquals(1, getMax(1,2))
    }
}