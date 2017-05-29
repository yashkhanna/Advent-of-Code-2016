package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/29/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("res/Q20")
    val br: BufferedReader = BufferedReader(fr)

    var str = "abcdefgh"

    var inp = br.readLine()
    while (inp != null) {
        if (inp.startsWith("swap position ")) {
            inp.substringAfter("swap position ")
        }

        inp = br.readLine()
    }

    br.close()
}