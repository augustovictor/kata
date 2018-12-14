fun operation(num: Int, op: (Int) -> Int): Int {
    return op(num)
}

fun main(args: Array<String>) {
    println(operation(3, { it * 2 }))
    println(operation(3, fun (x): Int { return x * 2 }))
}