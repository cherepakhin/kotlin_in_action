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
        private val brand: String  = "MERCEDES"
        override fun drive(): String {
            return "Mercedes is driving"
        }

        fun mersedesFunc(): String {
            return brand
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
        // поведение делегата задается интерфейсом ICar (НЕ УДАЛЯТЬ ЭТОТ КОММЕНТ)
        // БЕЗ(!!!) "ICar by brand":
        //        class CarDelegateWithExtended(brand: ICar) : ICar {
        //            fun extendedFunction(): String {
        //                return this.drive() + " from extended function"
        //            }
        //
        //            override fun drive(): String {
        //                TODO("Not yet implemented")
        //            }
        //        }
        // с помощью "by":
        // иными словами, выражение "ICar by brand" расширяет поведение CarDelegateWithExtended поведением класса "brand"
        // и эти функции МОГУТ БЫТЬ вызваны при обращении к методам класса CarDelegateWithExtended
        // Это не extends CarDelegateWithExtended,
        // т.к. поведение класса CarDelegateWithExtended расширяется динамически
        // Функции brand будут встроены в CarDelegateWithExtended,
        // (использовано ключевое слово "by")
        class CarDelegateWithExtended(brand: ICar) : ICar by brand {
            fun extendedFunction(): String {
                return this.drive() + " from extended function"
            }
        }

        // CarDelegate будет делегировать поведение классу Mercedes
        // н.п. можно вызвать функцию Mercedes также как
        val carDelegateWithExtended = CarDelegateWithExtended(Mercedes())

        assertEquals(
            "Mercedes is driving from extended function", carDelegateWithExtended.extendedFunction()
        )

        // mersedesFunc не определена ни в ICar, ни в CarDelegateWithExtended
        // поэтому недоступна в CarDelegateWithExtended и недоступна для делегирования
        // carDelegateWithExtended.mersedesFunc() - ERROR
        // из Mercedes, конечно, рабротает
        assertEquals("MERCEDES", Mercedes().mersedesFunc());
    }
}