import java.util.stream.Collectors

fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    return strings.stream()
        .map {
            if (it == str) {
                return@map "Banana"
            }
            it
        }
        .collect(Collectors.toList())
}