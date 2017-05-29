package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/24/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ9")
    val br: BufferedReader = BufferedReader(fr)
    val str = br.readLine()
    println("${len(str)}")

    br.close()
}

fun len(string: String): Long {
    if (string.isNullOrBlank()) {
        return 0L
    }
    var index = 0
    var ans = 0L
    while (index < string.length) {
        while (index < string.length && string[index] != '(') {
            index++
            ans++
        }

        if (index < string.length && string[index] == '(') {
            val str = string.substring(index).substringAfter('(').substringBefore(')')
            val params = str.split('x')
            val charCount = params[0].toInt()
            val multiplier = params[1].toInt()
            index += str.length + 2
            val x = len(string.substring(index, index + charCount))
            ans += multiplier * x
            index += charCount
        }
    }

    return ans
}