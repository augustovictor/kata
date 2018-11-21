package mystack

interface StackInterface {
    val capacity: Int
    val elements: MutableList<Int>
    var size: Int
    fun isEmpty(): Boolean
    fun push(i: Int)
    fun pop(): Int
    fun top(): Int
    fun find(i: Int): Int?
}