package adventofcode

/**
 * Created by yash.khanna on 5/29/2017.
 */
fun main(args: Array<String>) {
    val inp = 5

    val arr = ArrayList<Int>(inp)

    for (i in 0..inp - 1) {
        arr.add(i)
    }

    var st = 1
    while (arr.size > 1) {
        arr.removeAt(st)
        st = (st + 2).rem(inp)
    }

    arr.forEach { println(it) }
}