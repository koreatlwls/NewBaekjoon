package Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))

private fun main() = with(br) {
    val input = br.readLine()

    var stack = Stack<Char>()
    var inOut = false

    for(i in input.indices){
        if(input[i] == '<'){
            inOut = true

            while(stack.isNotEmpty()){
                print(stack.pop())
            }

            print(input[i])
        }else if(input[i] == '>'){
            inOut = false
            print(input[i])
        }else if(inOut){
            print(input[i])
        }else if(!inOut){
            if(input[i] ==' '){
                while(stack.isNotEmpty()){
                    print(stack.pop())
                }
                print(input[i])
            }else{
                stack.push(input[i])
            }
        }
    }
    while(stack.isNotEmpty()){
        print(stack.pop())
    }
}