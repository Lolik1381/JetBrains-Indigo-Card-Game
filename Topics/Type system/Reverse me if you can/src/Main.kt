fun reverse(input: Int?): Int {
    return input?.let {
        var result = 0

        var tmp = input
        while(tmp != 0) {
            result = result * 10 + tmp % 10
            tmp /= 10
        }
        return result
    } ?: -1
}