fun main() {



  println(test(null))




//    println(Sex.MALE.hashCode())
//    println(Sex.MALE.hashCode())
//
//    val person1 = Person("Иван", 20, Sex.MALE)
//    val person2 = Person("Нина", 39, Sex.MALE)
//    val person3 = Person("Коля", 39, Sex.MALE)
//    val person4 = Person("Иван", 20, Sex.MALE)
//
//    val persons = listOf(person1, person2, person3, person4)
//
//    println(persons.groupBy { CompositeKey<Sex, Int>(it.sex, it.age) })





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
