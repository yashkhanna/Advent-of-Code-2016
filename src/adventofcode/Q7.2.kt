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
        var set1: HashSet<Pair<Char, Char>> = HashSet()
        var set2: HashSet<Pair<Char, Char>> = HashSet()

        for (i in 0..arr.size - 1) {
            if (i.rem(2) == 0) {
                set1.addAll(checkSSLPattern(arr[i], true))
            } else {
                set2.addAll(checkSSLPattern(arr[i], false))
            }
        }
        if (set1.intersect(set2).isNotEmpty()) {
            ct++
        }

        str = br.readLine()
    }
    println(ct)

    br.close()
}

fun checkSSLPattern(string: String, boolean: Boolean): HashSet<Pair<Char, Char>> {
    var set: HashSet<Pair<Char, Char>> = HashSet()
    if (string.isNullOrBlank()) {
        return set
    }

    for (i in 0..string.length - 3) {
        if (string[i] == string[i + 2] && string[i] != string[i + 1]) {
            if (boolean)
                set.add(Pair(string[i], string[i + 1]))
            else
                set.add(Pair(string[i + 1], string[i]))
        }
    }
    return set
}