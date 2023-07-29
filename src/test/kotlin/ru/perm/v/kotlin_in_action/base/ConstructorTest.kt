package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConstructorTest {

    @Test
    internal fun defineDifferentConstructor() {
        class Address {
            private var houseNumber = "" // желательно все-таки тип указывать s:String
            constructor(s: String) {
                this.houseNumber = s
            }
            constructor(i: Int) {
                this.houseNumber = i.toString()
            }
            fun getHouseNumber():String {
                return houseNumber
            }
        }
        var address= Address("5")
        Assertions.assertEquals("5", address.getHouseNumber())
        address = Address(777)
        Assertions.assertEquals("777", address.getHouseNumber())

    }
}