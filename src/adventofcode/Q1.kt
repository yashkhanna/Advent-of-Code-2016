package adventofcode

import kotlin.collections.ArrayList

/**
 * Created by yash.khanna on 5/23/2017.
 */
fun main(args: Array<String>) {
    val inpString = "R4, R1, L2, R1, L1, L1, R1, L5, R1, R5, L2, R3, L3, L4, R4, R4, R3, L5, L1, R5, R3, L4, R1, R5, L1, R3, L2, R3, R1, L4, L1, R1, L1, L5, R1, L2, R2, L3, L5, R1, R5, L1, R188, L3, R2, R52, R5, L3, R79, L1, R5, R186, R2, R1, L3, L5, L2, R2, R4, R5, R5, L5, L4, R5, R3, L4, R4, L4, L4, R5, L4, L3, L1, L4, R1, R2, L5, R3, L4, R3, L3, L5, R1, R1, L3, R2, R1, R2, R2, L4, R5, R1, R3, R2, L2, L2, L1, R2, L1, L3, R5, R1, R4, R5, R2, R2, R4, R4, R1, L3, R4, L2, R2, R1, R3, L5, R5, R2, R5, L1, R2, R4, L1, R5, L3, L3, R1, L4, R2, L2, R1, L1, R4, R3, L2, L3, R3, L2, R1, L4, R5, L1, R5, L2, L1, L5, L2, L5, L2, L4, L2, R3"
//    val inpString = "R5, L5, R5, R3"
    val inp: List<String> = inpString.split(", ")

    var curr = Pair(0, 0)
    var face = "N"
    var edges: ArrayList<Pair<Pair<Int, Int>, Pair<Int, Int>>> = ArrayList()

    for (s in inp) {
        val direction: String = s.substring(0, 1)
        val distance: Int = s.substring(1).toInt()

        face = getDirection(face, direction)

        curr = when (face) {
            "N" -> Pair(curr.first, curr.second + distance)
            "S" -> Pair(curr.first, curr.second - distance)
            "E" -> Pair(curr.first + distance, curr.second)
            "W" -> Pair(curr.first - distance, curr.second)
            else -> curr
        }
    }

    println(curr)
    val sum = Math.abs(curr.first + curr.second)
    println("Answer is $sum")
}

fun getDirection(face: String, direction: String): String {
    val ans: String

    if (face.equals("N"))
        if (direction.equals("L"))
            ans = "W"
        else
            ans = "E"
    else if (face.equals("S"))
        if (direction.equals("L"))
            ans = "E"
        else
            ans = "W"
    else if (face.equals("E"))
        if (direction.equals("L"))
            ans = "N"
        else
            ans = "S"
    else
        if (direction.equals("L"))
            ans = "S"
        else
            ans = "N"

    return ans
}