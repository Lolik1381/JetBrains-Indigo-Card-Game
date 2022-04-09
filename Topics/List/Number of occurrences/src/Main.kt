fun solution(strings: List<String>, str: String): Int {
    return strings.stream()
        .filter { it == str }
        .count()
        .toInt()
}