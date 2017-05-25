package adventofcode

import java.security.MessageDigest
import java.util.*
import javax.xml.bind.DatatypeConverter

/**
 * Created by yash.khanna on 5/25/2017.
 */
fun main(args: Array<String>) {
    val inp = "qzthpkfp"

    val q: Queue<Quad> = LinkedList()
    q.add(Quad(0, 0, "", inp))
    var len = 0

    while (!q.isEmpty()) {
        val node = q.poll()
        val x = node.x
        val y = node.y
        val str = node.str
        val hash = node.hash

//        if (x == 3 && y == 3) {
//            println("$str")
//            len = str.length
//            break
//        }

        if (x == 3 && y == 3) {
//            println("$str")
            if (str.length > len)
                len = str.length
            continue
        }

        val newHash = md5(hash)

        val paths = newHash.toLowerCase().substring(0, 4)

        if (x - 1 in 0..3 && y in 0..3 && paths[0] in 'b'..'f') {
            q.add(Quad(x - 1, y, str + "U", hash + "U"))
        }
        if (x + 1 in 0..3 && y in 0..3 && paths[1] in 'b'..'f') {
            q.add(Quad(x + 1, y, str + "D", hash + "D"))
        }
        if (x in 0..3 && y - 1 in 0..3 && paths[2] in 'b'..'f') {
            q.add(Quad(x, y - 1, str + "L", hash + "L"))
        }
        if (x in 0..3 && y + 1 in 0..3 && paths[3] in 'b'..'f') {
            q.add(Quad(x, y + 1, str + "R", hash + "R"))
        }
    }
    print("$len")
}

fun md5(str: String) = DatatypeConverter.printHexBinary(
        MessageDigest.getInstance("MD5").digest(str.toByteArray()))

class Quad(val x: Int, val y: Int, val str: String, val hash: String)