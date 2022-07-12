package Implementation;

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val(N, M) = readln().split(" ").map{it.toInt()}
    val K = readln().toInt()
    var cnt = 0
    var police = 0
    val map = IntArray(K)

    for(i in 0 .. K){
        val(dir, loc) = readln().split(" ").map{it.toInt()}
        var tmp = 0
        when(dir){
            1 ->{
                tmp = loc
            }
            2 ->{
                tmp = N+M+N-loc
            }
            3 -> {
                tmp = N+M+N+M - loc
            }
            4 -> {
               tmp = N+loc
            }
        }

        if(i < K)map[i] = tmp
        else police = tmp
    }

    for(i in 0 until K){
        val path1 = abs(police - map[i])
        val path2 = 2*N+2*M-path1
        cnt += min(path1, path2)
    }

    println(cnt)
}
