package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PropertyTest {
    var myProp: String = ""
        get() {
            return field // field - key word
        }
        set(value) {
            field = value
        }

    @Test
    fun initMyPropTest() {
        Assertions.assertEquals("", myProp)
    }

    @Test
    fun setMyPropTest() {
        myProp = "VAL"
        Assertions.assertEquals("VAL", myProp)
    }
}