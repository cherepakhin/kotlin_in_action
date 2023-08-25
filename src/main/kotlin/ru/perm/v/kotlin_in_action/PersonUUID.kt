package ru.perm.v.kotlin_in_action

import java.util.*

class PersonUUID {
    val id: UUID
    val name: String

    constructor(id: UUID, name: String) {
        this.id = id
        this.name = name
    }

    constructor(name: String) {
        this.id = UUID.randomUUID()
        this.name = name
    }
}