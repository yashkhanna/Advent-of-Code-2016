package adventofcode

import java.math.BigInteger
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

/**
 * Created by yash.khanna on 5/26/2017.
 */
fun main(args: Array<String>) {
    val inp = "ffykfhsq"
    var str = inp
    var hash = ""
    var pass = ""
    var bigInt: BigInteger = BigInteger("-1")

    for (i in 1..8) {
        do {
            bigInt = bigInt.add(BigInteger.ONE)
            str = inp + bigInt
            hash = md5(str)
        } while (!checkHash(hash))
        pass += hash[5]
    }
    println(pass.toLowerCase())
}

fun checkHash(string: String) =
        string.substring(0, 5).matches(Regex("00000"))
