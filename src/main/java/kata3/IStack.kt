package kata3

interface IStack {
    val capacity: Int
    var size: Int
    fun push(i: Int)
    fun pop(): Int
    fun isEmpty(): Boolean
    fun top(): Int?
}