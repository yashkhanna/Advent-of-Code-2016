package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/23/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ3")
    val br: BufferedReader = BufferedReader(fr)

    var count = 0

    while (true) {
        val s1 = br.readLine()
        if (s1 == null)
            break

        val s2 = br.readLine()
        val s3 = br.readLine()

        val triangle1 = s1.split(" ")
        val triangle2 = s2.split(" ")
        val triangle3 = s3.split(" ")

        for (i in 0..2) {
            val x = triangle1[i].toInt()
            val y = triangle2[i].toInt()
            val z = triangle3[i].toInt()

            if (x + y > z && x + z > y && y + z > x) {
                count++
            }
        }
    }
    println("$count")

    br.close()
}