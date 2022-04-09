fun solution(products: List<String>, product: String) {
    val indexed = mutableListOf<Int>().apply {
        for ((index, p) in products.withIndex()) {
            if (p == product) {
                add(index)
            }
        }
    }

    println(indexed.joinToString(separator = " "))
}