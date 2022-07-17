package BinSearch

lateinit var lanCable : Array<Int>

fun main(){
    val(k,n) = readln().split(' ').map { it.toInt() }

    lanCable = Array(k){0}

    for(i in lanCable.indices){
        lanCable[i] = readln().toInt()
    }
    lanCable.sort()

    println(solve(k,n) -1)
}

fun solve(k:Int, n: Int) : Long{
    var minimumLan : Long = 0
    var maximumLan : Long = lanCable[lanCable.lastIndex] + 1.toLong()
    var mid : Long
    var count : Long

    while(minimumLan < maximumLan){
        mid = (maximumLan + minimumLan) / 2
        count = 0

        for(i in lanCable.indices){
            count+= (lanCable[i] / mid)
        }

        if(count < n)
            maximumLan = mid
        else
            minimumLan = mid + 1
    }

    return minimumLan
}