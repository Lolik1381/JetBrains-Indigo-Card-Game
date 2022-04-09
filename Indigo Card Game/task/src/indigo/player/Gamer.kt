package indigo.player

import indigo.Game
import indigo.enums.MenuAction

class Gamer : Player() {

    override fun handle(game: Game): String {
        println("Cards in hand: ${cardsInHand()}")

        while (true) {
            println("Choose a card to play (1-${cardsInHand.size}):")
            print("> ")

            try {
                val playerAction = readln()
                if (MenuAction.valueOfByMenuAction(playerAction)) {
                    menuHandlers[MenuAction.valueOf(playerAction.uppercase())]?.handler(cardsInHand)
                    continue
                }

                val index = playerAction.toInt() - 1
                val saveCard = cardsInHand[index]

                cardsInHand = cardsInHand.toMutableList().apply { removeAt(index) }

                return saveCard
            } catch (e: Exception) {
                continue
            }
        }
    }
}