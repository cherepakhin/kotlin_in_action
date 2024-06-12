package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DelegateCarTest {

    interface Car {
        fun drive(): String
    }

    class BMW : Car {
        override fun drive(): String{
            return "BMW is driving"
        }
    }

    class Mercedes : Car {
        override fun drive(): String{
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
        class CarDelegate(brand: Car) : Car by brand

        val carDelegate = CarDelegate(BMW())

        assertEquals("BMW is driving", carDelegate.drive())
    }
    @Test

    fun delegateMercedesTest()  {
        class CarDelegate(brand: Car) : Car by brand

        val carDelegate = CarDelegate(Mercedes())

        assertEquals("Mercedes is driving", carDelegate.drive())
    }
}