package ru.perm.v.kotlin_in_action.sealed

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

/**
 * В Kotlin, sealed class (запечатанный класс) представляет собой специальный вид класса,
 * который ограничивает возможность наследования от него.
 * sealed class MyResult {...}

 * class InheritFromMyResult : MyResult() // ERROR: This type is sealed, so it can be inherited by only its own nested classes or objects
 * обычное наследование недоступно, т.к. sealed class MyResult {...}
 *
 * SEALED.Он используется для создания ограниченного набора подклассов,
 * которые обычно представляют различные состояния или варианты в контексте паттерна
 * "sealed class hierarchy" или "алгебры типов".
 * В примере ниже Success и Error являются подклассами sealed class.
 * объекты Success и Error являются экземплярами конкретных подклассов.

 */
class SealedTest {

    // Обычное наследование
    @Test
    fun tryInherit() {
        open class RegularClass {
            var varLateInt: Int
            var varRegularClass = -1

            constructor() : super() {
                this.varLateInt = 10
            }

            constructor(varLateInt: Int) {
                this.varLateInt = varLateInt
            }

        }

        assertEquals(10, RegularClass().varLateInt)
        assertEquals(100, RegularClass(100).varLateInt)

        class InheritFromRegularClass : RegularClass {
            var varFromInheritRegularClass: Int = 100

            constructor()

            constructor(i: Int) {
                this
                this.varFromInheritRegularClass = i
            }

        }

        InheritFromRegularClass(300)
        assertEquals(10,  InheritFromRegularClass().varLateInt)
        assertEquals(-1,  InheritFromRegularClass().varRegularClass)
        assertEquals(100, InheritFromRegularClass().varFromInheritRegularClass)

        open class InheritFromOpenClass : RegularClass() { // RegularClass ->open - можно расширять
            var openVar: Int = 300
            var varInheritFromOpenClass: Int = 200
        }
        assertEquals(200, InheritFromOpenClass().varInheritFromOpenClass)
        assertEquals(300, InheritFromOpenClass().openVar)

        class InheritFromInheritClass : InheritFromOpenClass() {
        }
        assertEquals(200, InheritFromInheritClass().varInheritFromOpenClass)
        assertEquals(300, InheritFromInheritClass().openVar)
    }

    // sealed class (запечатанный класс) представляет собой специальный вид класса,
    // который ограничивает возможность наследования от него.
    // Здесь демо создания sealed class (запечатанного класса) с data class-ами (классов с данными) в нем
    sealed class MySealedClassResult {
        // data class - Нередко мы создаём классы, единственным назначением которых является хранение данных.
        data class Success(val data: String) : MySealedClassResult()
        data class Error(val message: String) : MySealedClassResult()
        object Loading : MySealedClassResult()
    }

    fun getResult(str: String = ""): MySealedClassResult {

        if (str == "DATA") return MySealedClassResult.Success(str)
        if (str == "ERROR") return MySealedClassResult.Error(str)
        return MySealedClassResult.Loading
    }

    @Test
    fun successTest() {

        val result = getResult("DATA")
        assertEquals("Success(data=DATA)", result.toString())
        assertEquals(MySealedClassResult.Success("DATA"), result)
        assertNotEquals(MySealedClassResult.Success("NOT DATA"), result)
    }

    @Test
    fun errorTest() {
        val result = getResult("ERROR")
        assertEquals(MySealedClassResult.Error("ERROR"), result)
    }

    @Test
    fun loadingTest() {
        val result = getResult("")
        assertEquals(MySealedClassResult.Loading, result)
    }

    @Test
    fun whehMyResultErrorTest() {
        val result = getResult("DATA")
        when (result) {
            is MySealedClassResult.Success -> assertEquals(MySealedClassResult.Success("DATA"), result);
            is MySealedClassResult.Error -> fail();
            is MySealedClassResult.Loading -> fail();
        }
    }
}