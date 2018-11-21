package kata2

interface IStack {
    val capacity: Int
    var size: Int
    var elements: Array<Int?>
    fun push(value: Int)
    fun pop(): Int
    fun isEmpty(): Boolean
    fun top(): Int
}