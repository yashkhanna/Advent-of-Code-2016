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
    var len = decompressRec(0, inp, 0L)

    println("$len")
    br.close()
}

fun decompressRec(st: Int, inp: String, length: Long): Pair<Long, Int> {
    if (st >= inp.length) {
        return Pair(length, st)
    }
    var len = length
    var index = st

    if (inp[index] == '(') {
        val str = inp.substring(index).substringAfter('(').substringBefore(')')
        val params = str.split('x')
        val charCount = params[0].toInt()
        val multiplier = params[1].toInt()
        index += str.length + 2
        len += multiplier * decompressRec(index, inp, len).first
        return Pair(len, index)
    } else {
        while (index < inp.length && inp[index] != '(' && inp[index] != ')') {
            index++
            len++
        }
        return decompressRec(index, inp, len)
    }
}

fun decompress(string: String): Long {
    var index = 0
    var length = 0L
    val len = string.length

    while (index < len) {
        val offset = extractPlainString(string, index)
        index += offset.first
        length += offset.second


    }
    string.startsWith("\\w")
    return length
}

fun extractPlainString(string: String, startIndex: Int): Pair<Int, Int> {
    var index = startIndex
    var len = 0
    while (index < string.length && string[index] != '(' && string[index] != ')') {
        len++
        index++
    }
    return Pair(index, len)
}