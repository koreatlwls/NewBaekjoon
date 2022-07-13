package Implementation

fun main(){
    val (r,c) = readln().split(' ').map{it.toInt()}
    val arr = Array(r){CharArray(c)}
    val result = mutableListOf<String>()

    for(i in 0 until r){
        val input = readln()
        arr[i] = input.toCharArray()
    }

    for(i in 0 until r){
        var tmp = ""
        var length = 0
        for(j in 0 until c) {
            if (arr[i][j] == '#') {
                if(length >= 2){
                    result.add(tmp)
                }
                length = 0
                tmp = ""
            } else {
                tmp += arr[i][j]
                length++
            }
        }
        if(tmp.length >= 2){
            result.add(tmp)
        }
    }

    for(i in 0 until c){
        var tmp = ""
        var length = 0
        for(j in 0 until r) {
            if (arr[j][i] == '#') {
                if(length >= 2){
                    result.add(tmp)
                }
                length = 0
                tmp = ""
            } else {
                tmp += arr[j][i]
                length++
            }
        }
        if(tmp.length >= 2){
            result.add(tmp)
        }
    }

    result.sort()
    print(result[0])
}