package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InheritTest {
    @Test
    fun inhertitanceTest() {
        open class Parent {
            override fun toString(): String {
                return "Parent"
            }
        }
        class InheritFromParent : Parent() {
            override fun toString(): String {
                return "InheritFromMyResult"
            }
        }
        val inheritFromParent = InheritFromParent()
        Assertions.assertEquals("InheritFromMyResult", inheritFromParent.toString())
    }

}