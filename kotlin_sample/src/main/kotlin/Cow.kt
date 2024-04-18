data class Cow(
    var name: String? = null,
    val age: Int? = null,
) {


    override fun toString(): String {
        return "Cow(name=$name, age=$age)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cow

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name?.hashCode() ?: 0
    }


}