package adventofcode

import java.math.BigInteger

/**
 * Created by yash.khanna on 5/26/2017.
 */
fun main(args: Array<String>) {
    var inp = "abc"
    var str = inp
    var index = BigInteger.ZERO

    var ct = 0
    var ans = index

    while (true) {
        str = inp + index
        

        val pair = three(md5(str))
        if (pair.first) {
//            println("triplet: $index")
            var temp: BigInteger = index
            var tempStr: String
            for (i in 1..1000) {
                temp = temp.add(BigInteger.ONE)
                tempStr = inp + temp
                if (five(md5(tempStr), pair.second)) {
//                    println("   quint: $temp")
                    ct++
                    ans = index
                    break
                }
            }
        }

        if (ct == 1) {
            print(ans)
            break
        }

        index = index.add(BigInteger.ONE)
    }
}

fun three(string: String): Pair<Boolean, Char> {
    var triplet = false
    var char = ' '
    var pair = Pair<Boolean, Char>(triplet, char)
    for (i in 0..string.length - 3) {
        if (string[i] == string[i + 1] && string[i + 1] == string[i + 2]) {
            triplet = true
            char = string[i]
            pair = Pair(triplet, char)
            break
        }
    }
    return pair
}

fun five(string: String, char: Char): Boolean {
    var quint = false
    for (i in 0..string.length - 5) {
        if (char == string[i] && string[i] == string[i + 1] && string[i + 1] == string[i + 2] && string[i + 2] == string[i + 3] && string[i + 3] == string[i + 4]) {
            quint = true
            break
        }
    }
    return quint
}