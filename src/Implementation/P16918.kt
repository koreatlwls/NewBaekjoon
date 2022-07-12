package Implementation

private val dir = arrayOf(
    intArrayOf(1, 0),
    intArrayOf(0, 1),
    intArrayOf(-1, 0),
    intArrayOf(0, -1)
)

fun install(r: Int, c: Int, graph: Array<IntArray>) {
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == 0) {
                graph[i][j] = 2
            }
        }
    }
}

fun bomb(r: Int, c: Int, graph: Array<IntArray>) {
    val graphCopy = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            graphCopy[i][j] = graph[i][j]
            if (graph[i][j] == 2) {
                graph[i][j] = 1
            }
        }
    }

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graphCopy[i][j] == 1) {
                graph[i][j] = 0
                for (k in 0 until 4) {
                    val nr = i + dir[k][0]
                    val nc = j + dir[k][1]
                    if (nr !in 0 until r || nc !in 0 until c) continue
                    graph[nr][nc] = 0
                }
            }
        }
    }
}

fun play(r: Int, c: Int, n: Int, graph: Array<IntArray>) {
    var time = 0
    var bombTime = 3
    while (time++ < n) {
        if (time % 2 == 0) {
            install(r, c, graph)
        }
        if (time == bombTime) {
            bomb(r, c, graph)
            bombTime += 2
        }
    }
}

fun main() {
    val (r, c, n) = readln().split(" ").map { it.toInt() }
    val graph = Array(r) { r ->
        val line = readln()
        var idx = 0
        IntArray(c) { c ->
            if (line[idx++] == '.') 0 else 1
        }
    }

    play(r, c, n, graph)

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == 0) {
                print(".")
            } else {
                print("O")
            }
        }
        println()
    }
}
