fun main() {
    val size = readLine()!!.toInt()

    val mutableList = mutableListOf<Int>().apply {
        for (i in 0 until size) {
            add(readLine()!!.toInt())
        }
    }
    shiftList(mutableList, readLine()!!.toInt())

    println(mutableList.joinToString(separator = " "))

    mutableMapOf<Int, Int>().
    mutableSetOf<Int>().subL
}

fun shiftList(list: MutableList<Int>, shift: Int) {
    val countShift = shift - list.size * (shift / list.size)

    for (j in 0 until countShift) {
        val last = list.last()
        for (i in list.lastIndex downTo 1) {
            list[i] = list[i - 1]
        }
        list[0] = last
    }
}