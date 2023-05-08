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
    fun sampleLambdaTest() {
        val items = listOf(1, 2, 3, 4, 5)

        // Лямбда - это блок кода, заключенный в фигурные скобки.
        items.fold(0, {
            // Если у лямбды есть параметры, то они указываются перед знаком '->'
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val myresult = acc + i
            println("result = $myresult")
            // Последнее выражение в лямбде считается возвращаемым значением:
            myresult
        })

        // Типы параметров в лямбде необязательны, если они могут быть выведены:
        //fold - функция свертывания для списков с начальным значением как аккум-р и функцией преобразование
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
        assertEquals("Elements: 1 2 3 4 5", "$joinedToString")
    }

    @Test
    fun lambdaTest() {
        val sum = { x: Int, y: Int -> x + y }
        assertEquals(3, sum(1, 2))
        // Unit - нет return
        val simpleLambda: () -> Unit = { println("Print Hello Kotlin") }
        simpleLambda()

    }

    @Test
    internal fun lambdaWithReturnTest() {
        val simpleLambdaWithReturn: () -> String = { "Return Hello Kotlin" }
        assertEquals("Return Hello Kotlin", simpleLambdaWithReturn())
    }

    @Test
    internal fun lambdaWithParamAndReturnTest() {
        val simpleLambdaWithReturn = {s1:String, s2:String ->  s1 + s2 }
        assertEquals("12", simpleLambdaWithReturn("1","2"))
    }

    @Test
    fun lambdaWithBodyReturnTest() {
        val simpleLambdaWithBodyAndReturn: () -> String = {
            val v = "Return val"
            v // return не нужен. Результатом будет последнее вычисление
        }
        assertEquals("Return val", simpleLambdaWithBodyAndReturn())
    }

    @Test
    fun foldTest() {
        // Функция fold также сводит все элементы потока в один.
        // Но в отличие от оператора reduce оператор fold в качестве первого параметра принимает начальное значение
        val resultFold = persons.fold("All ids->", { accum, person -> accum + person.id + "," })
        assertEquals("All ids->1,2,-1,", resultFold)
    }
}
