package adventofcode

import java.math.BigInteger

/**
 * Created by yash.khanna on 5/26/2017.
 */
fun main(args: Array<String>) {
    var inp = "ahsbgdzn"
    var str = StringBuilder()
    var index = BigInteger.ZERO

    var ct = 0
    var ans = index

    var map: HashMap<BigInteger, String> = HashMap<BigInteger, String>()

    while (true) {
        str.setLength(0)
        str.append(inp + index)

        val x: String
        if (map.containsKey(index)) {
            x = map.get(index) ?: ""
        } else {
            x = extendedmd5(str.toString())
        }

        val pair = three(x)
        if (pair.first) {
            println("triplet: $index")
            var temp: BigInteger = index
            var tempStr: StringBuilder = StringBuilder()
            for (i in 1..1000) {
                temp = temp.add(BigInteger.ONE)
                tempStr.setLength(0)
                tempStr.append(inp + temp)
                val x: String
                if (map.containsKey(temp)) {
                    x = map.get(temp) ?: ""
                } else {
                    x = extendedmd5(tempStr.toString())
                    map.put(temp, x)
                }
                if (five(x, pair.second)) {
                    println("   quint: $temp")
                    ct++
                    ans = index
                    break
                }
            }
        }

        if (ct == 64) {
            print(ans)
            break
        }

        index = index.add(BigInteger.ONE)
    }
}

fun extendedmd5(string: String): String {
    var str: StringBuilder = StringBuilder(string.toLowerCase())
    for (i in 1..2017) {
        val x = md5(str.toString())
        str.setLength(0)
        str = str.append(x.toLowerCase())
    }
    return str.toString().toLowerCase()
}