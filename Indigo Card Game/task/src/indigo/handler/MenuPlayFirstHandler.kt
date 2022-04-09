package indigo.handler

import indigo.Game
import indigo.player.Computer
import indigo.player.Gamer

class MenuPlayFirstHandler(
    private val game: Game
) : MenuHandler {

    private val answerToPlayerHandler = hashMapOf("yes" to PlayerHandler(game, Gamer()), "no" to PlayerHandler(game, Computer()))

    override fun handler(cards: List<String>): List<String> {
        while(true) {
            println("Play first?")
            print("> ")
            val answer = readLine()!!

            if (answerToPlayerHandler.containsKey(answer.lowercase())) {
                val secondPlayers = answerToPlayerHandler.filter { it.value != answerToPlayerHandler[answer]!! }

                game.players = listOf(
                    answerToPlayerHandler[answer]!!,
                    secondPlayers.entries.first().value
                )

                break
            }
        }

        return cards
    }
}