package indigo.handler

import indigo.Cards

class MenuGet : MenuHandler {

    override fun handler(cards: List<String>): List<String> {
        println("Number of cards:")
        print("> ")

        try {
            val number = readln().toInt()
            if (number !in 1..Cards.cards.size) {
                println("Invalid number of cards.")
                return cards
            }

            if (number > cards.size) {
                println("The remaining cards are insufficient to meet the request.")
                return cards
            }

            println(cards.subList(0, number).joinToString(separator = " "))
            return cards.subList(number, cards.size)
        } catch (ex: Exception) {
            println("Invalid number of cards.")
            return cards
        }
    }
}