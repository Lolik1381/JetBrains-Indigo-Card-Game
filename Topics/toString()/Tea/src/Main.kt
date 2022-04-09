open class Tea(val cost: Int, val volume: Int) {
    override fun toString(): String {
        return "cost=$cost, volume=$volume"
    }
}

class BlackTea(cost: Int, value: Int): Tea(cost, value) {

    override fun toString(): String {
        return "BlackTea{cost=$cost, volume=$volume}"
    }
}