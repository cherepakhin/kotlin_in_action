package ru.perm.v.kotlin_in_action.sealed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * В Kotlin, sealed class (запечатанный класс) представляет собой специальный вид класса,
 * который ограничивает возможность наследования от него.
 * Он используется для создания ограниченного набора подклассов,
 * которые обычно представляют различные состояния или варианты в контексте паттерна
 * "sealed class hierarchy" или "алгебры типов".
 */
class SealedTest {
    sealed class MyResult {
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
        val result = getResult("DATA")
        assertEquals(MyResult.Success("DATA"), result)
//        when (result) {
//            is MyResult.Success -> assertEquals(MyResult.Success("DATA"), result)
//            is MyResult.Error -> println("Error: ${result.message}")
//            MyResult.Loading -> println("Loading...")
//        }
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

}