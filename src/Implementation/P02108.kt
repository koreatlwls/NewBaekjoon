package Implementation

import kotlin.math.roundToInt

fun getAverage(list: MutableList<Int>): Int = list.average().roundToInt()

fun getMid(list: MutableList<Int>): Int {
    val sortedList = list.sorted()
    val mid = list.size / 2
    return sortedList[mid]
}

fun getFreq(list: MutableList<Int>): Int {
    val freqMap = list.groupingBy { it }.eachCount()
    val maxValue = freqMap.maxOf { it.value }
    val maxFreqMap = freqMap.filter{it.value == maxValue}
    val mapKeys = maxFreqMap.keys.sorted()
    return if(mapKeys.size == 1){
        mapKeys.first()
    }else{
        mapKeys[1]
    }
}

fun getRange(list : MutableList<Int>) : Int{
    val maxValue = list.maxOf { it }
    val minValue = list.minOf { it }
    return maxValue - minValue
}

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()

    repeat(n) {
        list.add(readln().toInt())
    }

    println("${getAverage(list)}")
    println("${getMid(list)}")
    println("${getFreq(list)}")
    println("${getRange(list)}")
}