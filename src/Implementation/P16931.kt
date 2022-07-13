package Implementation

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    val dir = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0))

    for (i in 0 until n) {
        readln().split(' ').forEachIndexed { index, s ->
            arr[i][index] = s.toInt()
        }
    }

    var ans = 2 * n * m
    for (i in 0 until n) {
        for (j in 0 until m) {
            for(k in 0 until 4){
                val nr = i + dir[k][0]
                val nc = j + dir[k][1]

                if(nr in (0 until n) && nc in (0 until m)) {
                    val diff = arr[i][j] - arr[nr][nc]
                    if (diff >= 0) ans += diff
                }else{
                     ans += arr[i][j]
                }
            }
        }
    }

    print(ans)
}