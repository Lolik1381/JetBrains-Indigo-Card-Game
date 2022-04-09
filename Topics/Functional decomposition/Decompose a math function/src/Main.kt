import kotlin.math.pow

fun f(x: Double): Double {
    return if (x <= 0) {
        f1(x)
    } else if (x > 0 && x < 1) {
        f2(x)
    } else {
        f3(x)
    }
}

// implement your functions here
fun f1(x: Double): Double {
    return x.pow(2.0) + 1
}

fun f2(x: Double): Double {
    return 1.0 / x.pow(2.0)
}

fun f3(x: Double): Double {
    return x.pow(2.0) - 1
}