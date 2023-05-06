package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PrimitiveTest {

    internal fun getMax(i1: Int, i2: Int): Int {
        return if (i1 > i2) i1 else i2
    }

    @Test
    internal fun maxFuncTest() {
        Assertions.assertEquals(2, getMax(1,2))
    }
}