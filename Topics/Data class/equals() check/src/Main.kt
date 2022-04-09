data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}

fun main() {

    val clients = mutableListOf<Client>().apply {
        for (i in 0..1) {
            add(Client(readln(), readln().toInt(), readln().toInt()))
        }
    }

    println(clients[0] == clients[1])
}