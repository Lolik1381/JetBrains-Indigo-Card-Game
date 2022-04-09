package indigo.handler

import indigo.Game

class InitialCardHandler(
    private val game: Game
) : MenuHandler {

    override fun handler(cards: List<String>): List<String> {
        val shuffleCard = MenuShuffle().handler(cards)
        val topCards = mutableListOf<String>().apply {
            for (i in 0 until 4) {
                add(shuffleCard[i])
            }
        }

        println("Initial cards on the table: ${topCards.joinToString(separator = " ")}")
        game.cardsOnTable = game.cardsOnTable.toMutableList().apply { addAll(topCards) }

        return shuffleCard.subList(4, shuffleCard.size)
    }
}