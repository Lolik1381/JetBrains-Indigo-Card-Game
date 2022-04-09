package indigo.handler

import indigo.Game
import indigo.player.Player

class PlayerHandler(
    private val game: Game,
    val player: Player
) : MenuHandler {

    override fun handler(cards: List<String>): List<String> {
        val nCard = player.takeCards(cards)

        if (game.cardsOnTable.isEmpty()) {
            println("\nNo cards on the table")
        } else {
            println("\n${game.cardsOnTable.size} cards on the table, and the top card is ${game.cardsOnTable.last()}")
        }

        if (game.totalCards.isEmpty() && player.cardsInHand.isEmpty()) {
            game.finalLogic()
            MenuExit().handler(cards)
        }

        game.cardsOnTable = game.cardsOnTable.toMutableList().apply { add(game.cardsOnTable.size, player.handle(game)) }
        game.gameLogic(player)

        return nCard
    }
}