package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/24/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ4")
    val br: BufferedReader = BufferedReader(fr)

    var s = br.readLine()

    while (s != null) {
//        val checksum = s.substringAfterLast("[").substringBeforeLast("]")
        val secId = s.substringAfterLast("-").substringBefore("[").toInt()
        val modSecId = secId.rem(26)
        val name = s.substringBeforeLast("-").toCharArray()
        var decrypt = ""

        for (char in name) {
            if (char.isLetter()) {
                decrypt += ((char.toInt() - 'a'.toInt() + modSecId).rem(26) + 'a'.toInt()).toChar()
            } else if (char == '-') {
                decrypt += ' '
            }
        }
        if (decrypt.contains("north"))
            println("$decrypt + $secId + $name")
        s = br.readLine()
    }
}