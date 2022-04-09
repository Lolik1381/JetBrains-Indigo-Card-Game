package indigo.player

import indigo.Game
import indigo.enums.MenuAction
import indigo.handler.MenuExit
import indigo.handler.MenuGet
import indigo.handler.MenuHandler
import indigo.handler.MenuReset
import indigo.handler.MenuShuffle

abstract class Player {
    companion object {
        private const val maxCard = 6
    }

    var cardsInHand: List<String> = mutableListOf()
    var scope: Int = 0
    var countCard: Int = 0
    val menuHandlers: Map<MenuAction, MenuHandler> = mapOf(
        MenuAction.RESET to MenuReset(),
        MenuAction.SHUFFLE to MenuShuffle(),
        MenuAction.GET to MenuGet(),
        MenuAction.EXIT to MenuExit()
    )

    fun cardsInHand(): String {
        val cardsInHand = mutableListOf<String>().apply {
            for (i in cardsInHand.indices) {
                add("${i + 1})${cardsInHand[i]}")
            }
        }

        return cardsInHand.joinToString(separator = " ")
    }

    fun takeCards(cards: List<String>): List<String> {
        if (this.cardsInHand.isEmpty() && cards.isNotEmpty()) {
            this.cardsInHand = cards.subList(0, maxCard)

            return cards.subList(maxCard, cards.size)
        }

        return cards
    }

    abstract fun handle(game: Game): String
}