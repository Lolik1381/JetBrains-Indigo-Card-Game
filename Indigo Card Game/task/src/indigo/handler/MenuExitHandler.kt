package indigo.handler

import kotlin.system.exitProcess

class MenuExit : MenuHandler {

    override fun handler(cards: List<String>): List<String> {
        println("Game Over")
        exitProcess(0)
    }
}