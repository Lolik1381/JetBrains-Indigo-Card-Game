package indigo

import indigo.handler.InitialCardHandler
import indigo.handler.MenuPlayFirstHandler
import indigo.handler.PlayerHandler
import indigo.player.Computer
import indigo.player.Gamer
import indigo.player.Player

class Game(
    var totalCards: List<String> = Cards.cards,
    var cardsOnTable: List<String> = mutableListOf(),
    var players: List<PlayerHandler> = mutableListOf()
) {
    private var lastWinner: Player? = null
    private val scopeService: ScoreService = ScoreService()

    fun start() {
        println("Indigo Card Game")
        totalCards = MenuPlayFirstHandler(this).handler(totalCards)
        totalCards = InitialCardHandler(this).handler(totalCards)

        while (true) {
            for (player in players) {
                totalCards = player.handler(totalCards)
            }
        }
    }

    fun gameLogic(player: Player) {
        if (cardsOnTable.size >= 2) {
            if (cardsOnTable[cardsOnTable.size - 2].last() == cardsOnTable.last().last() ||
                    cardsOnTable[cardsOnTable.size - 2].dropLast(1) == cardsOnTable[cardsOnTable.size - 1].dropLast(1)) {
                val winnerType = if (player is Gamer) {
                    "Player"
                } else {
                    "Computer"
                }
                println("$winnerType wins cards")

                winnerLogic(player)
                printWinner()
            }
        }
    }

    fun finalLogic() {
        lastWinner?.let {
            winnerLogic(it)
        } ?: winnerLogic(players[0].player)

        val maxCardPlayer = players.map { it.player }
            .maxByOrNull { it.countCard }!!
        maxCardPlayer.scope += 3

        printWinner()
    }

    private fun winnerLogic(player: Player) {
        player.countCard += cardsOnTable.size
        player.scope += scopeService.process(cardsOnTable)
        lastWinner = player

        cardsOnTable = mutableListOf()
    }

    private fun printWinner() {
        val (tmpPlayer, tmpComputer) = Pair(getPlayerWithType(Gamer::class.java), getPlayerWithType(Computer::class.java))
        println("Score: Player ${tmpPlayer.scope} - Computer ${tmpComputer.scope}")
        println("Cards: Player ${tmpPlayer.countCard} - Computer ${tmpComputer.countCard}")
    }

    private fun <T: Player> getPlayerWithType(clazz: Class<T>): Player {
        return players.map { it.player }
            .first { clazz.isAssignableFrom(it.javaClass) }
    }
}