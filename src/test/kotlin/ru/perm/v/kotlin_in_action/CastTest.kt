package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.lang.Long

class CastTest {

    @Test
    /**
     * Тестирование ключевого слова "is" (и "!is")
     * Применяется во всяких cast
     */
    fun testKeyWord_IS() {
        val s ="sss"
        var res = false
        if(s is String) {
            res = true
        }
        assertTrue(res)

        val l = Long(1)
        res = false
//        if(l is String) { ошибка. красным String
        if(l is Long) { // IS
            res = true
        }
        assertTrue(res)

        val personK = PersonK(1,"", 10)
        res = true
        if(personK !is PersonK) { // !IS
            res = false
        }
        assertTrue(res)
    }

    /**
     * Применение Any и cast
     */
    fun autoCast(s: Any): String {
        if (s is String) {
            // переменная s:Any, после "s is String" уже String
            return String.format("%s is String, length=%d", s, s.length)
        } else {
            return "Not String"
        }
    }

    @Test
    fun autoCastTest() {
        assertEquals("AAA is String, length=3", autoCast("AAA"))
        assertEquals("Not String", autoCast(100))
    }
}