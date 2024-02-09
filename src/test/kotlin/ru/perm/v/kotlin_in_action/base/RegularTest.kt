package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.stream.Collectors

class RegularTest {
    @Test
    fun byWord() {
        val content = "aaaa bbb cc"

        val pattern = "\\w+".toRegex()

        val words = pattern.findAll(content).map { it.value }.toList()

        assertEquals(3, words.count())
        assertEquals(listOf("aaaa", "bbb", "cc"), words.toList())

        val wordsList = arrayListOf<String>()
        words.forEach {
            wordsList.add(it)
        }
        assertEquals(listOf("aaaa", "bbb", "cc"), wordsList)

        val listFromCollectors = words.stream().filter { it.length > 2 }.collect(Collectors.toList())
        assertEquals(listOf("aaaa", "bbb"), listFromCollectors)
    }

    @Test
    fun withSplit() {
        val content = "aaaa bbb cc d eeeee"
        val regex = """\W+""".toRegex()

        val filtered = regex.split(content).filter { it.length > 2 }

        assertEquals(listOf("aaaa", "bbb", "eeeee"), filtered)
    }
}