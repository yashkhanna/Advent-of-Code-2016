package adventofcode

/**
 * Created by yash.khanna on 5/26/2017.
 */
fun main(args: Array<String>) {
    var str = "11110010111001001"
    val len = 35651584

    while (str.length <= len) {
        val temp = str
        val reverse = temp.reversed().toCharArray()
        reverse.forEachIndexed { index, c -> if (c == '0') reverse[index] = '1' else reverse[index] = '0' }
        str = str + "0" + String(reverse)
    }
    str = str.substring(0, len)

    var checksum = str
    var newCheckSum = StringBuilder("")

    while (checksum.length.rem(2) == 0) {
        var i = 0
        newCheckSum.setLength(0)
        while (i < checksum.length) {
            val one = checksum[i]
            val two = checksum[i + 1]
            newCheckSum.append(if (one == two) 1 else 0)
            i += 2
        }
        checksum = newCheckSum.toString()
    }
    print(checksum)
}