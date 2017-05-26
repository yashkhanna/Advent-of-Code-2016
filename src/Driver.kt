fun main(args: Array<String>): Unit {
    println("Hello world !")
    val person: Person = Person(1, "yash")
    val person2: Person = Person(2, "khanna")
    println("Persons are $person and $person2")
    length("ab")
}

fun fib(num: Int): Int {
    if (num == 0 || num == 1)
        return 1
    else
        return fib(num - 1) + fib(num - 2)
}

fun length(str: String): Int {
    require(str.length > 3){ "string length is less than 2"}
    return str.length
}