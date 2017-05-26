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
    var pass = CharArray(8, { _ -> ' ' })
    var bigInt: BigInteger = BigInteger("-1")
    var passGenerated = false
    while (!passGenerated) {
        passGenerated = true
        do {
            bigInt = bigInt.add(BigInteger.ONE)
            str = inp + bigInt
            hash = md5(str)
        } while (!checkHash(hash))
        if (hash[5] in '0'..'7' && pass[hash[5].toInt() - '0'.toInt()] == ' ')
            pass[hash[5].toInt() - '0'.toInt()] = hash[6]
        for (i in 0..7)
            if (pass[i] == ' ')
                passGenerated = false
    }
    for (i in 0..7)
        print(pass[i].toLowerCase())
}