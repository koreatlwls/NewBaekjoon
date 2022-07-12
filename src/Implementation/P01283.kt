fun main() {
    val n = readln().toInt()
    val alphaSet = mutableSetOf<Char>()

    for (i in 0 until n) {
        val sen = readln().split(' ')
        var idx = 0
        var wordPass = true
        while (idx < sen.size) {
            if (alphaSet.indexOf(sen[idx][0]) == -1) {
                alphaSet.add(sen[idx][0].lowercaseChar()).also { alphaSet.add(sen[idx][0].uppercaseChar()) }
                wordPass = false
                break
            }
            idx++
        }

        if (wordPass) {
            var senPass = false
            for (i in sen.indices) {
                for (j in 0 until sen[i].length) {
                    if (alphaSet.indexOf(sen[i][j]) == -1 && !senPass) {
                        print("[${sen[i][j]}]")
                        alphaSet.add(sen[i][j].lowercaseChar()).also { alphaSet.add(sen[i][j].uppercaseChar()) }
                        senPass = true
                    } else {
                        print("${sen[i][j]}")
                    }
                }
                print(" ")
            }
        } else {
            for (i in sen.indices) {
                if (i == idx) {
                    print("[${sen[i][0]}]${sen[i].substring(1)} ")
                } else {
                    print("${sen[i]} ")
                }
            }
        }
        println()
    }
}