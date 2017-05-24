package adventofcode

import java.io.BufferedReader
import java.io.FileReader
import java.util.stream.Collector

/**
 * Created by yash.khanna on 5/24/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ4")
    val br: BufferedReader = BufferedReader(fr)

    var s = br.readLine()
    var sum = 0

    while (s != null) {
        val checksum = s.substringAfterLast("[").substringBeforeLast("]")
        val secId = s.substringAfterLast("-").substringBefore("[").toInt()
        val name = s.substringBeforeLast("-").replace("-", "").toCharArray()

        val map: Array<Pair<Char, Int>> = Array(26, { i -> Pair((i + 'a'.toInt()).toChar(), 0) })

        for (char in name) {
            val index = char.toInt() - 'a'.toInt()
            map[index] = Pair(char, map[index].second + 1)
        }

        val sortedMap = map.sortedWith(compareBy({ it.second }, { 'z' - it.first })).reversed()

        var string = ""
        for (i in 0..4) {
            string += sortedMap[i].first
        }

        if (string == checksum) {
            sum += secId
        }

        s = br.readLine()
    }

    println(sum)
}