package Implementation

fun main(){
    var (n, k) = readln().split(' ').map { it.toInt() }
    var cnt = 0

    while(n.countOneBits() > k ){
        n++
        cnt++
    }

    println(cnt)
}