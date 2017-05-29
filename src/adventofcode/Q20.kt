package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/29/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("res/Q20")
    val br: BufferedReader = BufferedReader(fr)

    val ds = ArrayList<Pair<Long, Long>>()

    var str = br.readLine()
    while (str != null) {
        val range = str.split("-")
        ds.add(Pair(range[0].toLong(), range[1].toLong()))
        str = br.readLine()
    }

    ds.sortBy { it.first }

    /**
     * Part 1
     */
    var ip = 0L

    for (pair in ds) {
        if (ip >= pair.first && ip <= pair.second) {
            ip = pair.second.inc()
        } else if (ip < pair.first) {
            break
        }
    }
    println("$ip")

    /**
     * Part 2
     */
    var ct = 0L
    var maxip = 0L

    for (pair in ds) {
        if (maxip >= pair.first && maxip <= pair.second) {
            maxip = pair.second.inc()
        } else if (maxip < pair.first) {
            ct += pair.first - maxip
            maxip = pair.second.inc()
        }
    }
    println("$ct")

    br.close()
}