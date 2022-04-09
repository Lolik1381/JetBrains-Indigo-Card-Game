fun solution(first: List<Int>, second: List<Int>): MutableList<Int> {
    return mutableListOf<Int>().apply {
        addAll(first)
        addAll(second)
        sort()
    }
}