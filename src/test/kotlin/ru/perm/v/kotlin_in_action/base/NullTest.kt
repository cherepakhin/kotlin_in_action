package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NullTest { // public не нужен, т.к используется ТОЛЬКО внутри СВОЕГО пакета
    @Test
    internal fun simple() {
//        var a:String; // RED ERROR. Не скомпилируется. "Variable a must be initialize"
//        Assertions.assertEquals("", a);  // a RED ERROR.
        var a = "AA"
        a = "AAA"
        Assertions.assertEquals("AAA", a);
        val b: String?;
//        Assertions.assertEquals("", b) // Тоже не скомпилируется. "Variable a must be initialize". Нужно присвоить значение
    }

    @Test
    internal fun canNull() {
        val aNull: String? = null // Знак ? позволяет присвоить null
        Assertions.assertNull(aNull)
    }

    @Test
    internal fun canAssignTest() {
        class A {
            var enabled: Boolean = false
                get() = field
        }

        val a: A = A()
        Assertions.assertFalse(a.enabled)
        a.enabled = true
        Assertions.assertTrue(a.enabled)
        a.enabled = false
        Assertions.assertFalse(a.enabled)
    }
}