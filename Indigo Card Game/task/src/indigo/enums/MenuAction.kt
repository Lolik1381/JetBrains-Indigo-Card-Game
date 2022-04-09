package indigo.enums

enum class MenuAction(val menuAction: String) {
    RESET("reset"),
    SHUFFLE("shuffle"),
    GET("get"),
    EXIT("exit");

    companion object {

        fun valueOfByMenuAction(menuAction: String): Boolean {
            return values()
                .map { it.menuAction }
                .any { it == menuAction }
        }
    }
}