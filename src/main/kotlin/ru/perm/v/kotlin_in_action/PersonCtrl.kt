package ru.perm.v.kotlin_in_action

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/person")
class PersonCtrl {
    val notFoundPerson = PersonK(-1, "NOT FOUND PERSON", 0)
    val persons = listOf(
        PersonK(100, "name100", 100), // для проверки сортировки
        PersonK(1, "name1", 10),
        PersonK(2, "name2", 20),
    )

    @GetMapping("/")
    fun index() = persons.sortedBy { p -> p.id }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): PersonK {
        return persons.filter { p -> p.id == id }.getOrElse(0, { notFoundPerson })
    }

}