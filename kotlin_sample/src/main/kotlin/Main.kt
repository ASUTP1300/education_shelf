import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.stream.IntStream
import kotlin.streams.asSequence

fun main() {

    println(listOf("SPRING_DATASOURCE_URL").filter { s -> s.lowercase().contains("url") })


//    val list = mutableListOf(null, 1)
//
//    println(list.maxOf { it ?: 0 })
//
//    val autos = IntStream.range(0, 10).mapToObj { Auto(it) }.toList()


//    try {
//
//        autos.asSequence().onEach {
//            if (it.num == 3 || it.num == 8) {
//                throw RuntimeException("Дырка!!")
//            }
//        }.forEach { println("Успешная обработка $it") }
//
//    } catch (e: Exception) {
//        println("Ошибка при обработке авто $e!!")
//    }


//
//    autos.asSequence().onEach {
//        try {
//            if (it.num == 3 || it.num == 8) {
//                throw RuntimeException("Дырка!!")
//            }
//        } catch (e: Exception) {
//            println("Ошибка при обработке авто $it!!")
//            throw RuntimeException("ОШибка")
//        }
//    }.forEach { println("Успешная обработка $it") }

}


class Auto(var num: Int) {
    override fun toString(): String {
        return "Auto(num=$num)"
    }
}

class Dog(var name: String? = null, val age: Int) {
    override fun toString(): String {
        return "Dog(name=$name, age=$age)"
    }
}

class Person2 {
    var name: String = "ee"
    var age: Int = 0
}

fun test(n: Int?): Int {

    n ?: return Int.MAX_VALUE.also { println("Ничего не пришло(((") }

    return n

}

enum class Sex {

    MALE,
    FEMALE,
    UNKNOWN
}


class Person(val name: String, val age: Int, val sex: Sex) {
    override fun toString(): String {
        return "Person(name='$name', age=$age, sex=$sex)"
    }
}


data class CompositeKey<T, R>(val k1: T, val k2: R) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CompositeKey<*, *>) return false

        return k1 == other.k1 && k2 == other.k2
    }

    override fun hashCode(): Int {
        return 31 * k1.hashCode() + k2.hashCode()
    }

}
