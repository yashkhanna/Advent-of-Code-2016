package adventofcode

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by yash.khanna on 5/25/2017.
 */
fun main(args: Array<String>) {
    val file = Files.readAllLines(Paths.get("D:/LearningKotlin/Project1/src/adventofcode/inputQ23"))

    val map: HashMap<String, Int> = HashMap()
    var list: IntArray = IntArray(51, { _ -> 0})
    var valueOfA = -1

    for (j in 0..300) {
        valueOfA++
        var x = 0
        for (i in 0..50) {
            if (i.rem(2) == 0 && list[i] == 0) x++
            else if (i.rem(2) != 0 && list[i] == 1) x++
        }
        if (x==51) {
            println("Answer is above")
            break
        }
        for (i in 0..50)
            list[i] = 0
        map.put("a", valueOfA)
        map.put("b", 0)
        map.put("c", 0)
        map.put("d", 0)

        x = 0
        var ctr = 0
        var pc = 0
        print("${map.get("a")} : ")
        while (pc < file.size) {
            val str = file[pc]
            if (str.startsWith("cpy")) {
                val args = str.substringAfter("cpy ").split(' ')
                val src = args[0]
                val dest = args[1]

                if (src.matches(Regex("^-?\\d+$"))) {
                    map.set(dest, src.toInt())
                } else {
                    map.put(dest, map.getValue(src))
                }
                pc++
            } else if (str.startsWith("inc")) {
                val args = str.substringAfter("inc ")
                if (map.containsKey(args)) {
                    map.set(args, map.get(args)!! + 1)
                }
                pc++
            } else if (str.startsWith("dec")) {
                val args = str.substringAfter("dec ")
                if (map.containsKey(args)) {
                    map.set(args, map.get(args)!! - 1)
                }
                pc++
            } else if (str.startsWith("tgl")) {
                val args = str.substringAfter("tgl ")
                if (map.containsKey(args)) {
                    val index = map.get(args)!!.toInt() + pc
                    if (index < file.size) {
                        file[index] = toggleInstru(file[index])
                    }
                }
                pc++
            } else if (str.startsWith("jnz")) {
                val args = str.substringAfter("jnz ").split(' ')
                val src = args[0]
                val dest = args[1]

                val srcVal: Int
                val destLong: Int

                srcVal = if (src.matches(Regex("^-?\\d+$"))) {
                    src.toInt()
                } else if (map.containsKey(src)) {
                    map.getValue(src)
                } else {
                    1
                }

                if (srcVal != 0) {
                    destLong = if (dest.matches(Regex("^-?\\d+$"))) {
                        dest.toInt()
                    } else if (map.containsKey(dest)) {
                        map.getValue(dest)
                    } else {
                        1
                    }
                    pc += destLong
                } else {
                    pc++
                }
            } else if (str.startsWith("out")) {
                val args = str.substringAfter("out ")
                val op = if (args.matches(Regex("^-?\\d+$"))) {
                    args.toInt()
                } else if (map.containsKey(args)) {
                    map.getValue(args)
                } else {
                    -1
                }
//                ctr++
                pc++
                print("$op, ")
                list[ctr] = op
                ctr++
                if (ctr > 50)
                    break
            } else {
                pc++
            }
        }
        println("")
    }

//    println("${map.get("a")}")
}

fun toggleInstru(instr: String): String {
    val newInstr =
            if (instr.contains("inc"))
                instr.replace("inc", "dec")
            else if (instr.contains("dec"))
                instr.replace("dec", "inc")
            else if (instr.contains("tgl"))
                instr.replace("tgl", "inc")
            else if (instr.contains("cpy"))
                instr.replace("cpy", "jnz")
            else if (instr.contains("jnz"))
                instr.replace("jnz", "cpy")
            else
                ""
    return newInstr
}