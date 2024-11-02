fun main() {
    val man = Man("John")
    val name = man.name

    man.name = "Ruslan"

    println("name $name")
    println("Man, ${man}!")

}

data class Man(var name: String)