package Implementation

fun main() {
    val n = readln().toInt()
    val carEnter = HashMap<String, Int>()

    for (i in 0 until n) {
        carEnter[readln()] = i
    }

    val out = IntArray(n)
    for (i in 0 until n) {
        out[i] = carEnter[readln()]!!
    }

    var count = 0
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (out[i] > out[j]) {
                count++
                break
            }
        }
    }

    print(count)
}