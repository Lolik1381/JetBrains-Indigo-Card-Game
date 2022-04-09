fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
    return numbers.toMutableList().apply {
        add(number)
    }
}