package Implementation

fun main() {
    val n = readln().toInt()

    var count = 0
    var i = 0

    while (count < n) {
        i += 1
        if (hasThreeContinuousSix(i)) count += 1
    }

    println(i)
}

fun hasThreeContinuousSix(n: Int): Boolean {
    var num = n
    var count = 0

    while (num > 0) {
        if (num % 10 == 6) {
            count += 1
            if (count == 3) return true
        } else count = 0
        num /= 10
    }

    return false
}