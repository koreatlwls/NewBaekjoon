package Implementation

fun main() {
    val set = LinkedHashSet<String>()

    var arr = readln().split(' ')
    for(i in 0 until arr[1].toInt()){
        var number = readln()

        if(set.contains(number)){
            set.remove(number)
        }
        set.add(number)
    }

    val it : Iterator<String> = set.iterator()
    var count = 1
    while(it.hasNext()){
        println(it.next())
        if(count==arr[0].toInt())break
        count++
    }
}