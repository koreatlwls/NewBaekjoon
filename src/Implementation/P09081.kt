package Implementation

fun main(){
    val testCase = readln().toInt()

    repeat(testCase){
        val input = readln().toCharArray()
        for(i in input.size-2 downTo  0){
            var biggerCh = Pair(Int.MAX_VALUE, 0)
            for(j in i until input.size){
                if(input[i] < input[j]){
                    biggerCh = Pair(biggerCh.first.coerceAtMost(input[j].code), j)
                }
            }

            if(biggerCh.first != Int.MAX_VALUE){
                input[i] = biggerCh.first.toChar().also { input[biggerCh.second] = input[i] }
                input.sort(i+1, input.size)
                break
            }
        }

        println(String(input))
    }
}