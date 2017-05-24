package adventofcode

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by yash.khanna on 5/24/2017.
 */
fun main(args: Array<String>) {
    val fr = FileReader("D:/LearningKotlin/Project1/src/adventofcode/inputQ8")
    val br: BufferedReader = BufferedReader(fr)

    val matrix = Array(6, { CharArray(50, { _ -> '.' }) })
    printMatrix(6, 50, matrix)
    var op = br.readLine()

    while (op != null) {
        if (op.startsWith("rect")) {
            val params = op.substringAfter(' ').split('x')
            val cols = params[0].toInt()
            val rows = params[1].toInt()

            for (i in 0..rows - 1)
                for (j in 0..cols - 1)
                    matrix[i][j] = '#'
        } else if (op.startsWith("rotate row")) {
            val params = op.substringAfter("rotate row y=").split(" by ")
            val row = params[0].toInt()
            val offset = params[1].toInt()

            for (j in 0..offset - 1) {
                var prev: Char = matrix[row][49]
                var curr: Char
                for (i in 0..49) {
                    curr = matrix[row][i]
                    matrix[row][i] = prev
                    prev = curr
                }
            }
        } else if (op.startsWith("rotate column")) {
            val params = op.substringAfter("rotate column x=").split(" by ")
            val col = params[0].toInt()
            val offset = params[1].toInt()

            for (j in 0..offset - 1) {
                var prev: Char = matrix[5][col]
                var curr: Char
                for (i in 0..5) {
                    curr = matrix[i][col]
                    matrix[i][col] = prev
                    prev = curr
                }
            }
        }
        op = br.readLine()
    }

    printMatrix(6, 50, matrix)
    var pixels = 0
    for (i in 0..5) {
        for (j in 0..49) {
            if (matrix[i][j] == '#')
                pixels++
        }
    }

    print("$pixels")
    br.close()
}

fun printMatrix(rows: Int, cols: Int, matrix: Array<CharArray>) {
    for (i in 0..rows - 1) {
        for (j in 0..cols - 1) {
            if (j.rem(5) == 0)
                print(" ")
            print(matrix[i][j])
        }
        println("")
    }
}