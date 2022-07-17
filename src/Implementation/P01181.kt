package Implementation

fun main() {
    val n = readln().toInt()
    val set = mutableSetOf<String>()

    repeat(n) {
        set.add(readln())
    }

    val resultSet = set.sortedWith(Comparator { o1, o2 ->
        when {
            o1.length < o2.length -> -1
            o1.length == o2.length -> when {
                o1 < o2 -> -1
                else -> 1
            }
            else -> 1
        }
    })

    for(item in resultSet){
        println(item)
    }
}