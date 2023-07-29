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
        var address= Address("5") // передается строка в constructor(s: String)
        Assertions.assertEquals("5", address.getHouseNumber())
        address = Address(777) // передается число в constructor(i: Int)
        Assertions.assertEquals("777", address.getHouseNumber())

    }
}