package indigo.handler

import indigo.Cards

class MenuReset : MenuHandler {

    override fun handler(cards: List<String>): List<String> {
        println("Card deck is reset.")
        return Cards.cards
    }
}