package adventofcode

import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader

/**
 * Created by yash.khanna on 5/23/2017.
 */
fun main(args: Array<String>) {
//    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ3")
    val fr = FileReader("res/Q3")
    val br: BufferedReader = BufferedReader(fr)

    var count = 0

    var s = br.readLine()

    while (s != null) {
        val triangle = s.split(" ")
        val x = triangle[0].toInt()
        val y = triangle[1].toInt()
        val z = triangle[2].toInt()

        if (x + y > z && x + z > y && y + z > x) {
            count++
        }
        s = br.readLine()
    }
    println("$count")

    br.close()
}