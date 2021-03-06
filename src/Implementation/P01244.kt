package Implementation;

import kotlin.math.min

fun main()  {
    val n = readln().toInt()
    val switches = BooleanArray(n) { false }
    readln()
        .split(" ")
        .forEachIndexed { index, s ->
            switches[index] = s != "0"
        }
    val t = readln().toInt()

    for (i in 0 until t) {
        var (gender, idx) = readln().split(" ").map { it.toInt() }
        idx--

        when (gender) {
            1 -> {
                for (j in idx until n step (idx + 1)) {
                    switches[j] = !switches[j]
                }
            }
            else -> {
                val min = min(n - (idx + 1), idx)

                for (j in 0..min) {
                    if (j != 0) {
                        if (switches[idx - j] == switches[idx + j]) {
                            switches[idx + j] = !switches[idx + j]
                            switches[idx - j] = !switches[idx - j]
                        } else {
                            break
                        }
                    } else {
                        switches[idx] = !switches[idx]
                    }
                }
            }
        }
    }

    println(
        switches
            .map { if (it) 1 else 0 }
            .chunked(20)
            .joinToString("\n") { it.joinToString(" ") }
    )
}