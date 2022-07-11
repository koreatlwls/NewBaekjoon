package Implementation

fun Int.toIntList(): List<Int> {
    val intList = mutableListOf<Int>()
    var temp = this
    while (temp != 0) {
        intList.add(temp % 10)
        temp /= 10
    }

    return intList
}

fun main() {
    var candidateNumbers = createCandidateNumbers()
    val n = readln().toInt()
    repeat(n) {
        val (number, strike, ball) = readln().split(" ").map { it.toInt() }
        candidateNumbers = candidateNumbers.filter { candidateNumber ->
            val resultStrike = getStrike(candidateNumber, number.toIntList())
            val resultBall = getBall(candidateNumber, number.toIntList())
            isSameStrikeAndBall(resultStrike, resultBall, strike, ball)
        }.toMutableList()
    }

    println("${candidateNumbers.size}")
}

fun createCandidateNumbers(): MutableList<List<Int>> {
    val candidateNumbers = mutableListOf<List<Int>>()
    for (i in 1..9) {
        for (j in 1..9) {
            for (k in 1..9) {
                if (areDistinctNumbers(i, j, k)) {
                    candidateNumbers.add(listOf(i, j, k))
                }
            }
        }
    }

    return candidateNumbers
}

fun areDistinctNumbers(firstNumber: Int, secondNumber: Int, thirdNumber: Int): Boolean {
    return firstNumber.xor(secondNumber) * secondNumber.xor(thirdNumber) * thirdNumber.xor(firstNumber) != 0
}

fun getStrike(candidateNumber: List<Int>, inputNumber: List<Int>): Int {
    var strike = 0
    for (i in candidateNumber.indices) {
        if (candidateNumber[i] == inputNumber[i]) strike++
    }

    return strike
}

fun getBall(candidateNumber: List<Int>, inputNumber: List<Int>): Int {
    var ball = 0
    for (i in candidateNumber.indices) {
        for (j in inputNumber.indices) {
            if (i != j && candidateNumber[i] == inputNumber[j]) ball++
        }
    }

    return ball
}

fun isSameStrikeAndBall(resultStrike: Int, resultBall: Int, inputStrike: Int, inputBall: Int): Boolean {
    return resultStrike == inputStrike && resultBall == inputBall
}