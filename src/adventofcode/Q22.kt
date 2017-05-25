package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/25/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("res/Q22")
    val br: BufferedReader = BufferedReader(fr)
    br.readLine()
    br.readLine()

    val list: ArrayList<Tuple> = ArrayList()

    var str = br.readLine()
    while (str != null) {
        val args = str.trim().split(" ")
        val size = args[1].toInt()
        val used = args[2].toInt()
        val avl = args[3].toInt()
        list.add(Tuple(size, used, avl))
        str = br.readLine()
    }

    var count = 0

    for (i in 0..list.size-1) {
        for (j in  0..list.size-1) {
            if (i == j)
                continue

            if (list[i].used < list[j].avail)
                count++
        }
    }

    println("${count/2}")
    br.close()
}

class Tuple(val size: Int, val used: Int, val avail: Int)