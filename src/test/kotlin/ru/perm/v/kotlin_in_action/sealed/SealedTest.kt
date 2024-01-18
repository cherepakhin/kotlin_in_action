package ru.perm.v.kotlin_in_action.sealed

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * В Kotlin, sealed class (запечатанный класс) представляет собой специальный вид класса,
 * который ограничивает возможность наследования от него.
 * Он используется для создания ограниченного набора подклассов,
 * которые обычно представляют различные состояния или варианты в контексте паттерна
 * "sealed class hierarchy" или "алгебры типов".
 * В примере ниже Success и Error являются подклассами sealed class.
 * объекты Success и Error являются экземплярами конкретных подклассов.
 */
class SealedTest {
    // sealed class (запечатанный класс) представляет собой специальный вид класса,
    // который ограничивает возможность наследования от него.
    // Здесь демо создания sealed class (запечатанного класса) и data classов (классов с данными) в нем
    sealed class MyResult {
        // data class - Нередко мы создаём классы, единственным назначением которых является хранение данных.
        data class Success(val data: String) : MyResult()
        data class Error(val message: String) : MyResult()
        object Loading : MyResult()
    }

    fun getResult(str: String = ""): MyResult {
        if (str == "DATA") return MyResult.Success(str)
        if (str == "ERROR") return MyResult.Error(str)
        return MyResult.Loading
    }

    @Test
    fun successTest() {
        // ERROR: This type is sealed, so it can be inherited by only its own nested classes or objects
        // class InheritDataClass : MyResult()

        val result = getResult("DATA")
        assertEquals("Success(data=DATA)", result.toString())
        assertEquals(MyResult.Success("DATA"), result)
        assertNotEquals(MyResult.Success("NOT DATA"), result)
    }

    @Test
    fun errorTest() {
        val result = getResult("ERROR")
        assertEquals(MyResult.Error("ERROR"), result)
    }

    @Test
    fun loadingTest() {
        val result = getResult("")
        assertEquals(MyResult.Loading, result)
    }

    @Test
    fun whehMyResultErrorTest() {
        val result = getResult("DATA")
        when (result) {
            is MyResult.Success -> assertEquals(MyResult.Success("DATA"), result);
            is MyResult.Error -> fail();
            is MyResult.Loading -> fail();
        }
    }
}