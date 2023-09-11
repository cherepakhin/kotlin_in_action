package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ANull {
    val nullableVaL:Boolean? = null

    @Test
    internal fun isNullTest() {
        assertNull(nullableVaL)
    }

}