fun main() {
    val count = readLine()!!.toInt()

    val list = mutableListOf<Int>()
    for (i in 0 until count) {
        list.add(readLine()!!.toInt())
    }

    val last = list.last()
    for (i in list.lastIndex downTo 1) {
        list[i] = list[i - 1]
    }
    list[0] = last

    println(list.joinToString(separator = " "))
}