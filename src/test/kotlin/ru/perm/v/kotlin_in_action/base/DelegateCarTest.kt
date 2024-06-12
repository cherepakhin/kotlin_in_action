package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Паттерн делегирования (Delegation)
 * https://java-ru-blog.blogspot.com/2020/02/delegation-pattern-java.html
 * Это техника, в которой объект выражает определенное поведение снаружи,
 * но в реальности делегирует ответственность за реализацию этого поведения связанному объекту.
 */
class DelegateCarTest {

    interface ICar {
        fun drive(): String
    }

    class BMW : ICar {
        override fun drive(): String {
            return "BMW is driving"
        }
    }

    class Mercedes : ICar {
        override fun drive(): String {
            return "Mercedes is driving"
        }
    }

    @Test
    fun bmwDriveTest() {
        assertEquals("BMW is driving", BMW().drive())
    }

    @Test
    fun mersDriveTest() {
        assertEquals("Mercedes is driving", Mercedes().drive())
    }

    @Test
    fun delegateBmwTest() {
        class CarDelegate(brand: ICar) : ICar by brand //

        // CarDelegate будет делегировать поведение классу BMW
        val carDelegate = CarDelegate(BMW())

        assertEquals("BMW is driving", carDelegate.drive())
    }

    @Test
    fun delegateMercedesTest() {
        // определяется класс
        // CarDelegate принимает ICar, и принимает ВСЁ его поведение
        // такая вот конструкция...
        class CarDelegate(brand: ICar) : ICar by brand

        val carDelegate = CarDelegate(Mercedes())

        assertEquals("Mercedes is driving", carDelegate.drive())

    }

    @Test
    fun delegateBehaviorTest()  {
        // поведение делегата задается интерфейсом ICar
        class CarDelegateWithExtended(brand: ICar) : ICar by brand {
            fun extendedFunction(): String {
                return this.drive() + " from extended function"
            }
        }

        // CarDelegate будет делегировать поведение классу Mercedes
        val carDelegateWithExtended = CarDelegateWithExtended(Mercedes())

        assertEquals(
            "Mercedes is driving from extended function", carDelegateWithExtended.extendedFunction()
        )
    }
}