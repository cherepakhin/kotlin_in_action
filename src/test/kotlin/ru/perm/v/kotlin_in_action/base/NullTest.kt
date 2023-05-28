package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NullTest { // public не нужен
    @Test
    internal fun simple() {
//        var a:String;
//        Assertions.assertEquals("", a); // Не скомпилируется. RED ERROR. "Variable a must be initialize"
        var a = "AA"
        a ="AAA"
        Assertions.assertEquals("AAA", a);
    }

    @Test
    internal fun canNull() {
        val aNull:String? = null // Знак ? позволяет присвоить null
        Assertions.assertNull(aNull)
    }
}