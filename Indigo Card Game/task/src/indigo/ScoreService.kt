package indigo

class ScoreService {

    private val scoreCard = mapOf("A" to 1, "10" to 1, "J" to 1, "Q" to 1, "K" to 1)

    fun process(cards: List<String>): Int {
        return cards.map { it.dropLast(1) }
            .filter { scoreCard.containsKey(it) }
            .map { scoreCard[it]!! }
            .sumOf { it }
    }
}