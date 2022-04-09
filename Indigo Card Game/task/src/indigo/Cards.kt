package indigo

object Cards {
    private val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val suits = listOf("♦", "♥", "♠", "♣")
    val cards = mutableListOf<String>().apply {
        for (i in suits.indices) {
            for (j in ranks.indices) {
                add(String.format("%s%s", ranks[j], suits[i]))
            }
        }
    }
}