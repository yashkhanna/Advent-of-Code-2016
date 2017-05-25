package adventofcode

import java.util.*

/**
 * Created by yash.khanna on 5/25/2017.
 */
fun main(args: Array<String>) {
    val inp = 1362
    val maze = Array(32, { CharArray(40, { _ -> '#' }) })

    for (i in 0..31) {
        for (j in 0..39) {
            if (isEven(noOfOnesInBinary(f(i, j, inp))))
                maze[i][j] = '.'
        }
    }

    val dist = Array(32, { IntArray(40, { _ -> -1 }) })
    val visited = Array(32, { BooleanArray(40, { _ -> false }) })

    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(1, 1))
    dist[1][1] = 0

    printArray(32, 40, maze)
    while (!q.isEmpty()) {
        val curr = q.poll()
        visited[curr.first][curr.second] = true

        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j == 0) {
                    continue
                }
                if ((i == 0 || j == 0) && inRange(curr.first + i, curr.second + j) && maze[curr.first + i][curr.second + j] != '#' && !visited[curr.first + i][curr.second + j]) {
                    dist[curr.first + i][curr.second + j] = dist[curr.first][curr.second] + 1
                    q.add(Pair(curr.first + i, curr.second + j))
                }
            }
        }
    }
    println("${dist[31][39]}")

    var ct = 0
    for (i in 0..31) {
        for (j in 0..39) {
            if (dist[i][j] >= 0 && dist[i][j] <= 50)
                ct++
        }
    }
    println("$ct")
}

fun inRange(x: Int, y: Int) = (x >= 0 && x < 32 && y >= 0 && y < 40)

fun f(x: Int, y: Int, inp: Int) = (x + y) + (x + y) * (x + y) + 2 * x + inp

fun isEven(num: Int) = (num.rem(2) == 0)

fun noOfOnesInBinary(num: Int): Int {
    var count = 0
    var n = num
    while (n != 0) {
        if (n.and(1) == 1)
            count++

        n = n.shr(1)
    }

    return count
}

fun noOfOnesInBinaryOptimized(num: Int): Int {
    var count = 0
    var n = num
    while (n != 0) {
        if (n.and(1) == 1)
            count++

        n.shr(1)
    }

    return count
}

fun printArray(rows: Int, cols: Int, matrix: Array<CharArray>) {
    for (i in 0..rows - 1) {
        for (j in 0..cols - 1) {
            print(matrix[i][j])
        }
        println("")
    }
}