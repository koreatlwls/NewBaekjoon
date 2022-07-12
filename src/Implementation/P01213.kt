package Implementation

var evenCount = 0
var oddCount = 0
var nameLength = 0
val intArr = IntArray(26) { 0 }

fun main() {
    val name = readln()

    nameLength = name.length

    name.forEach { intArr[it - 'A']++ }

    intArr.forEach {
        if (it % 2 == 0) evenCount++
        else oddCount++
    }

    if (nameLength % 2 == 0) {
        if (oddCount != 0) {
            println("I'm Sorry Hansoo")
            return
        } else {
            println(palindrome())
        }
    } else {
        if (oddCount != 1) {
            println("I'm Sorry Hansoo")
            return
        } else {
            println(palindrome())
        }
    }
}

fun palindrome(): String {
    var ret = ""

    when (nameLength % 2) {
        0 -> {
            for (i in intArr.indices) {
                if (intArr[i] != 0) {
                    repeat(intArr[i] / 2) {
                        ret += ('A' + i)
                    }
                }
            }

            ret += ret.reversed()
        }
        else -> {
            var oddIdx = 0

            for (i in intArr.indices) {
                if (intArr[i] != 0) {
                    if (intArr[i] % 2 == 0) {
                        repeat(intArr[i] / 2) {
                            ret += ('A' + i)
                        }
                    } else {
                        if (intArr[i] > 2) {
                            repeat(intArr[i] / 2) {
                                ret += ('A' + i)
                            }
                        }

                        oddIdx = i
                    }
                }
            }

            ret += (('A' + oddIdx) + ret.reversed())
        }
    }

    return ret
}