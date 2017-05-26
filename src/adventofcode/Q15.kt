package adventofcode

/**
 * Created by yash.khanna on 5/26/2017.
 */
fun main(args: Array<String>) {
    var time = 0

    var disc: ArrayList<Pair<Int, Int>> = ArrayList()
    disc.add(Pair(13, 11))
    disc.add(Pair(5, 0))
    disc.add(Pair(17, 11))
    disc.add(Pair(3, 0))
    disc.add(Pair(7, 2))
    disc.add(Pair(19, 17))
    disc.add(Pair(11, 0))

    while (true) {
        var state = true

        for (i in 0..disc.size - 1) {
            if ((disc[i].second + i + time + 1).rem(disc[i].first) != 0) {
                state = false
            }
        }

        if (state) {
            break
        }

        time++
    }

    print("$time")

}