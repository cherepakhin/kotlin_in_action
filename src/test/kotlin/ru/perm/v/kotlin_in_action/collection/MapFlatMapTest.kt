package ru.perm.v.kotlin_in_action.collection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.streams.toList

/**
 * Различия между map() и flatmap()
 * MAP преобразует один-в-один
 * FLATMAP - превращает каждый объект потока в поток других объектов.
 *      Содержимое этих потоков затем упаковывается в возвращаемый поток метода flatMap
 *      .flatMap(f -> f.bars.stream())
 *          .forEach(b -> System.out.println(b.name));
 */
class MapFlatMapTest {
    class Product(val id: Int = 0, val name: String = "") {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Product) return false

            if (id != other.id) return false
            if (name != other.name) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id
            result = 31 * result + name.hashCode()
            return result
        }
    }

    open class Stock(val id: Int = 0, val name: String = "", val products: List<Product>)

    @Test
    fun mapTest() {
        val product11 = Product(11, "Product11")
        val stock1 = Stock(
            1, "stock1", listOf(
                product11,
                Product(12, "Product12"),
                Product(13, "Product13"),
                Product(14, "Product14")
            )
        )
        val stock2 = Stock(
            2, "stock2", listOf(
                product11, // as in stock1[0]
                Product(22, "Product22"),
                Product(23, "Product23")
            )
        )
        val stocks = listOf(stock1, stock2)

        assertEquals(2, stocks.size);

        val mapProducts = stocks.map { it.products }.toList()
        assertEquals(2, mapProducts.size); // listOf(list<Product>(), list<Product>())) size =2

        val flatmapProducts = stocks.flatMap { it.products }
        assertEquals(7, flatmapProducts.size); // list<Product>() size =7

        // delete duplicates https://www.baeldung.com/kotlin/collections-remove-duplicates
        assertEquals(6, flatmapProducts.toMutableSet().toList().size)

    }

    @Test
    fun sumList() {
        val product11 = Product(11, "Product11")
        val stock1 = Stock(
            1, "stock1", listOf(
                Product(12, "Product12"),
                Product(13, "Product13"),
                Product(14, "Product14"),
                product11
            )
        )
        val stock2 = Stock(
            2, "stock2", listOf(
                Product(22, "Product22"),
                product11, // as in stock1[0]
                Product(23, "Product23")
            )
        )
//                            [12, 13, 14, 11]          [22, 11, 23]
        val sumProducts=(stock1.products.toList() + stock2.products.toList())
        assertEquals(7, sumProducts.size)
        assertEquals(listOf(12, 13, 14, 11, 22, 11, 23), sumProducts.stream().map { it.id }. toList())

        val removedDuplicate = sumProducts.toMutableSet().toList() // duplicate product11 REMOVED!!! Cause: to...SET()
        assertEquals(6, removedDuplicate.size)
        assertEquals(listOf(12, 13, 14, 11, 22, 23), removedDuplicate.stream().map { it.id }. toList())
    }
}