package Implementation

fun main() {
    while (true) {
        val str = readln()
        if (str == "*") break

        var isDPair: Boolean = true

        for (i in 1..str.length - 2) {
            isDPair = true
            val set = hashSetOf<String>()

            for (j in i until str.length) {
                if (!set.add(str[j - i].toString() + str[j].toString())) isDPair = false
            }

            if (!isDPair) break
        }

        if (!isDPair) println("$str is NOT surprising.")
        else println("$str is surprising.")
    }
}