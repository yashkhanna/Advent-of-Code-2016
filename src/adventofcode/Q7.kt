package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/29/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("res/Q7")
    val br: BufferedReader = BufferedReader(fr)

    var str = br.readLine()
    var ct = 0
    while (str != null) {
        val arr = str.split(Regex("[\\[\\]]"))

        var answer = false
        for (i in 0..arr.size - 1) {
            if (i.rem(2) == 0) {
                answer = answer.or(checkTLSPattern(arr[i]))
            } else {
                if (checkTLSPattern(arr[i])) {
                    answer = false
                    break
                }
            }
        }
        ct = if (answer) ct.inc() else ct

        str = br.readLine()
    }
    println(ct)

    br.close()
}

fun checkTLSPattern(string: String): Boolean {
    if (string.isNullOrBlank()) {
        return false
    }
    var pattern = false
    for (i in 0..string.length - 4) {
        if (string[i] == string[i + 3] && string[i + 1] == string[i + 2] && string[i] != string[i + 1]) {
            pattern = true
        }
    }
    return pattern
}