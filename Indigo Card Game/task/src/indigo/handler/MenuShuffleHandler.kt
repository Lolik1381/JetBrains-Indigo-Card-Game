package indigo.handler

class MenuShuffle : MenuHandler {

    override fun handler(cards: List<String>): List<String> {
        return cards.shuffled()
    }
}