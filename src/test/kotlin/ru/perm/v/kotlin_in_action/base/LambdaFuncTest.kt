package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.PersonK

class LambdaFuncTest {
    val persons = listOf(
        PersonK(1, "NAME1", 10),
        PersonK(2, "NAME2", 20),
        PersonK(-1, "NAME-1", null)
    )

    @Test
    fun getByIndexTest() {
        val p = persons.get(1)
        assertEquals(2, p.id)
    }

    @Test
    fun sampleFoldForSumTest() {
        val items = listOf(1, 2, 3, 4, 5) // сумма = 15

        // Лямбда - это блок кода, заключенный в фигурные скобки.
        // Задание и ВЫПОЛНЕНИЕ для items функции fold (функция свертки для коллекций)
        // Fold применяется к items
        val printAndSumFunc = items.fold(0) {
            // или так, но пишется предупреждение val printAndSumFunc = items.fold(0, {
            // Если у лямбды есть параметры, то они указываются перед знаком '->'
            // acc - значение, вычисленное(возвращенное) на пред.этапе. Начальное значение в первом параметре fold
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val myresult = acc + i
            println("result = $myresult")
            // Последнее выражение в лямбде считается возвращаемым значением:
            myresult
        }
        assertEquals(15, printAndSumFunc)

        // Типы параметров в лямбде необязательны, если они могут быть выведены:
        //fold - функция свертывания для списков с начальным значением как аккум-р и функцией преобразование
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
        assertEquals(/* expected = */ "Elements: 1 2 3 4 5", /* actual = */ joinedToString)
    }

    @Test
    fun sampleFoldForStringTest() {
        val items = listOf(1, 2, 3, 4, 5)

        // Лямбда - это блок кода, заключенный в фигурные скобки.
        // Задание и тут же ВЫПОЛНЕНИЕ алгоритма для items сделано функцией fold (свертка)
        // Fold применяется к items
        // Типы параметров в лямбде необязательны, если они могут быть выведены:
        // fold - функция свертывания для списков с начальным значением как аккум-р и функцией преобразование
        // задано выражение и результат этого выражения будет return (сам "return" можно не указывать)
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

        assertEquals("Elements: 1 2 3 4 5", "$joinedToString") // for example calculate joinedToString
    }

    @Test
    fun lambdaTest() {
        val sum = { x: Int, y: Int -> x + y }
        assertEquals(3, sum(1, 2))
        // Unit - нет return
        val simpleLambda: () -> Unit = { println("Print Hello Kotlin") }
        // Вызов лямбды. Просто печатает, ничего не возвращает (указано Unit)
        simpleLambda()
    }

    @Test
    fun lambdaWithReturnTest() {
        val simpleLambdaWithReturn: () -> String = { "Returned value" }
        assertEquals("Returned value", simpleLambdaWithReturn())
    }

    @Test
    internal fun lambdaWithParamAndReturnTest() {
        val simpleLambdaWithReturn = { s1: String, s2: String -> s1 + s2 }
        assertEquals("12", simpleLambdaWithReturn("1", "2"))
    }

    @Test
    fun lambdaWithBodyReturnTest() {
        val simpleLambdaWithBodyAndReturn: () -> String = {
            val v = "Return val"
            v // return можно не указывать, не нужен. Результатом будет "v"
        }
        assertEquals("Return val", simpleLambdaWithBodyAndReturn())

        val simpleLambdaWithBodyAndReturn1: () -> String = {
            val val1 = "VAL1"
            val val2 = "VAL2"
            "$val1 $val2" // return можно не указывать. Результатом будет вычисленное значение
            // val1+" "+val2 // можно и так. Idea рекомендует то, что выше "$val1 $val2" с явным указанием, что речь идет о строках
        }
        assertEquals("VAL1 VAL2", simpleLambdaWithBodyAndReturn1())
    }

    @Test
    fun foldTest() {
        // Функция fold также сводит все элементы потока в один.
        // Но в отличие от оператора reduce оператор fold в качестве
        // первого параметра принимает начальное значение,
        // второго - лямбду для вычисления
        val resultFold = persons.fold("All ids->", { accum, person -> accum + person.id + "," })
        assertEquals("All ids->1,2,-1,", resultFold)
    }

    @Test
    fun reduceTest() {
        val listUsers = listOf("Tom", "Bob", "Kate", "Sam", "Alice")
        val reducedValue = listUsers.reduce { a, b -> "$a $b" }
        assertEquals("Tom Bob Kate Sam Alice", reducedValue)
    }

    @Test
    fun sumIdsWithFold() {
        val listPerson = listOf(
            PersonK(10, "NAME10", 10),
            PersonK(20, "NAME20", 20),
            PersonK(30, "NAME30", null)
        )

        val sumIds = listPerson.fold(0, { acc, personK -> acc + personK.id })

        assertEquals(60, sumIds)
    }

    @Test
    fun sumAgeWithFilterAndFold() {
        val listPerson = listOf(
            PersonK(10, "NAME10", 10),
            PersonK(20, "NAME20", 20),
            PersonK(30, "NAME30", null)
        )

        val sumAge = listPerson
            .filter { it.age != null }
            .fold(0, { acc, personK -> acc + personK.age!! })

        assertEquals(30, sumAge)
    }

    @Test
    fun listWithFilterAgeNotNull() {
        val listPerson = listOf(
            PersonK(10, "NAME10", 10),
            PersonK(20, "NAME20", 20),
            PersonK(30, "NAME30", null)
        )

        val persons = listPerson
            .filter { it.age != null }


        assertEquals(2, persons.size)
    }

    @Test
    fun sumAgeWithFilterAgeNotNull() {
        val listPerson = listOf(
            PersonK(10, "NAME10", 10),
            PersonK(20, "NAME20", 20),
            PersonK(30, "NAME30", null)
        )

        val sumAge = listPerson
            .filter { it.age != null }.fold(0, { acc, personK -> acc + personK.age!! })

        assertEquals(30, sumAge)
    }

    @Test
    fun lambdaPairAndDSL() {
        // Kotlin DSL: Теория и Практика
        // https://habr.com/ru/companies/haulmont/articles/341402/

        val helloPrint: (String) -> Unit = { println(it) }
        helloPrint("Hello")

        val helloWithReturn: (String) -> String = { "Hello, " + it }
        assertEquals("Hello, Vasi", helloWithReturn("Vasi"))

        val helloWithParams: (String, Int) -> Unit = { a, b -> println("a=$a, b=$b") }
        helloWithParams("A", 100)

        val pair = Point(10, 20)
        val x = pair.first
        val y = pair.second
        assertEquals(10, x)
        assertEquals(20, y)

        val x1 = pair.component1()
        val y1 = pair.component2()
        assertEquals(10, x1)
        assertEquals(20, y1)

        val (x2, y2) = Point(1, 2)
        assertEquals(1, x2)
        assertEquals(2, y2)
    }

}

