package adventofcode

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by yash.khanna on 5/25/2017.
 */
fun main(args: Array<String>) {
    val file = Files.readAllLines(Paths.get("D:/LearningKotlin/Project1/src/adventofcode/inputQ23"))

    val map: HashMap<String, Int> = HashMap()
    map.put("a", 12)
    map.put("b", 0)
    map.put("c", 0)
    map.put("d", 0)
    var pc = 0

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
                    file[index] = toggleInstruction(file[index])
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
        } else {
            pc++
        }

    }
    println("${map.get("a")}")

}

fun toggleInstruction(instr: String): String {
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