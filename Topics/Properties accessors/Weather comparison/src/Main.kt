class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value in -92..57) {
                value
            } else {
                valueOfByName(name).temperature
            }
        }

    companion object {
        enum class DefaultTemperature(val temperature: Int, val nameCity: String) {
            DUBAI(30, "Dubai"),
            MOSCOW(5, "Moscow"),
            HANOI(20, "Hanoi")
        }
        
        fun valueOfByName(name: String): DefaultTemperature {
            return DefaultTemperature.values().find { it.nameCity == name }!!
        }
    }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val minCity = mutableListOf(firstCity, secondCity, thirdCity).groupBy { it.degrees }
        .filter { it.value.size == 1 }
        .minByOrNull { it.value[0].degrees }?.value?.get(0)?.name
    println(minCity ?: "neither")
}