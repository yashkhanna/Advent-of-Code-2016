package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/24/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ9")
    val br: BufferedReader = BufferedReader(fr)

    var inp = br.readLine()
    var index = 0
    var len = 0

    while (index < inp.length) {
        while (index < inp.length && inp[index] != '(' && inp[index] != ')') {
            index++
            len++
        }

        val str = inp.substring(index).substringAfter('(').substringBefore(')')
        val params = str.split('x')
        val charCount = params[0].toInt()
        val multiplier = params[1].toInt()

        len += (charCount * multiplier)
        index += charCount + str.length + 2
    }

    println("$len")
    br.close()
}