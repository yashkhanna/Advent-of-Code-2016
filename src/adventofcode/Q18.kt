package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/26/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("res/Q18")
    val br: BufferedReader = BufferedReader(fr)
    val inp = br.readLine()
    val len = inp.length
    val rows = 400000

    val arr = Array(rows, { CharArray(len, { _ -> '.' }) })
    arr.set(0, inp.toCharArray())

    for (i in 1..rows - 1) {
        for (j in 0..len - 1) {
            val x: Boolean = (if (j == 0) true else (arr[i - 1][j - 1] == '.'))
            val y: Boolean = (arr[i - 1][j] == '.')
            val z: Boolean = (if (j == len - 1) true else (arr[i - 1][j + 1] == '.'))

            if ((!x && y && z) || (x && y && !z) || (!x && !y && z) || (x && !y && !z))
                arr[i][j] = '#'
        }
    }
    var ct = 0L
    for (i in 0..rows - 1) {
        for (j in 0..len - 1) {
            ct = if (arr[i][j] == '.') ct + 1 else ct
        }
    }
    print("$ct")

    br.close()
}