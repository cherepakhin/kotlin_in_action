package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ANull {
    val enabled:Boolean? = null

    @Test
    internal fun isNullTest() {
        Assertions.assertNull(enabled)
    }

}