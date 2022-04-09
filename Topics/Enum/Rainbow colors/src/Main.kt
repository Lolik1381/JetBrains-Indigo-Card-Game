fun main() {
    val color = readLine()!!

    if (ColorRainbow.valueOfByName(color)) {
        println("true")
    } else {
        println("false")
    }
}

enum class ColorRainbow(val nameColor: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet");

    companion object {

        fun valueOfByName(name: String): Boolean {
            return values()
                .map { it.nameColor }
                .any { it == name }
        }
    }
}