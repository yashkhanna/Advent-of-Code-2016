package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/24/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ6")
    val br: BufferedReader = BufferedReader(fr)

    var str = br.readLine()
    val cols = str.length

    val ds = Array(26, { IntArray(cols) })

    for (i in 0..25) {
        for (j in 0..cols - 1) {
            ds[i][j] = 0
        }
    }

    while (str != null) {
        val charArr = str.toCharArray()

        for (i in 0..charArr.size - 1) {
            val index = charArr[i] - 'a'
            ds[index][i]++
        }

        str = br.readLine()
    }

    var op = ""

    for (i in 0..cols - 1) {
        var maxIndex = 0
        for (j in 0..25) {
            if (ds[j][i] > ds[maxIndex][i]) {
                maxIndex = j
            }
        }
        op += (maxIndex + 'a'.toInt()).toChar()
    }

    println("$op")
}