package indigo.player

import indigo.Game
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.random.nextInt

class Computer : Player() {

    override fun handle(game: Game): String {
        println(cardsInHand.joinToString(separator = " "))

        if (cardsInHand.size == 1) {
            return playsCard(0)
        }

        if (game.cardsOnTable.isEmpty()) {
            return playsCard(getIndexByCard(this.cardsInHand, emptyTableStrategy(this.cardsInHand)))
        }

        val cardsCandidate = getCardsCandidate(this.cardsInHand, game.cardsOnTable.last())
        if (cardsCandidate.isEmpty()) {
            return playsCard(getIndexByCard(this.cardsInHand, emptyTableStrategy(this.cardsInHand)))
        }

        if (cardsCandidate.size == 1) {
            return playsCard(getIndexByCard(this.cardsInHand, cardsCandidate.first()))
        }

        return playsCard(getIndexByCard(this.cardsInHand, variableCandidateStrategy(this.cardsInHand, game.cardsOnTable.last())))
    }

    private fun playsCard(index: Int): String {
        val saveCard = cardsInHand[index]

        println("Computer plays $saveCard")
        cardsInHand = cardsInHand.toMutableList().apply { removeAt(index) }

        return saveCard
    }

    private fun emptyTableStrategy(cards: List<String>): String {
        cards.groupingBy { it.last() }
            .eachCount()
            .filter { it.value > 1 }
            .takeIf { it.isNotEmpty() }?.let {
                return cards.find { card -> card.last() == it.maxByOrNull { maxValue -> maxValue.value }!!.key}!!
            }

        cards.groupingBy { it.dropLast(1) }
            .eachCount()
            .filter { it.value > 1 }
            .takeIf { it.isNotEmpty() }?.let {
                return cards.find { card -> card.dropLast(1) == it.maxByOrNull { maxValue -> maxValue.value }!!.key}!!
            }

        return cards[Random(LocalDateTime.now().nano).nextInt(cards.indices)]
    }

    private fun variableCandidateStrategy(cards: List<String>, topCardOnTable: String): String {
        cards.filter { it.last() == topCardOnTable.last() }.takeIf { it.size > 1 }?.let {
            return it.first()
        }

        cards.filter { it.dropLast(1) == topCardOnTable.dropLast(1) }.takeIf { it.size > 1 }?.let {
            return it.first()
        }

        return getCardsCandidate(cards, topCardOnTable).first()
    }

    private fun getIndexByCard(cards: List<String>, card: String): Int {
        cards.forEachIndexed { index, value ->
            if (value == card) {
                return index
            }
        }

        throw Exception("Error")
    }

    private fun getCardsCandidate(cards: List<String>, topCardOnTable: String): Set<String> {
        return mutableSetOf<String>().apply {
            addAll(getRankCardCandidate(cards, topCardOnTable))
            addAll(getCountSuitsCardCandidate(cards, topCardOnTable))
        }
    }

    private fun getRankCardCandidate(cards: List<String>, topCardOnTable: String): List<String> {
        val topRank = topCardOnTable.dropLast(1)
        return cards.filter { it.dropLast(1) == topRank }
    }

    private fun getCountSuitsCardCandidate(cards: List<String>, topCardOnTable: String): List<String> {
        val topSuits = topCardOnTable.last()
        return cards.filter { it.last() == topSuits }
    }
}