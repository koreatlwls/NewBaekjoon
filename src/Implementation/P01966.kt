package Implementation

import java.util.*

/*
fun main() = with(System.`in`.bufferedReader()) {
    var testCase = readLine().toInt()

    while (testCase-- > 0) {
        val(n, target) = readLine().split(" ").map{it.toInt()}

        val queue : Queue<Pair<Int, Int>> = LinkedList()
        val pq : PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        var count = 0

        val st : StringTokenizer = StringTokenizer(readLine())
        for(j in 0 until n){
            val priority = st.nextToken().toInt()
            queue.offer(Pair(j, priority))
            pq.offer(priority)
        }

        while(!queue.isEmpty()){
            val job : Pair<Int, Int> = queue.poll()
            if(job.second == pq.peek()){
                count++
                pq.poll()

                if(job.first == target){
                    break
                }
            }else{
                queue.offer(job)
            }
        }

        println(count)
    }
}*/
