package mystack

import mystack.exceptions.Empty
import mystack.exceptions.Overflow
import mystack.exceptions.Underflow

class ZeroCapacityStack: StackInterface {
    override fun top(): Int = throw Empty()
    override fun find(i: Int): Int? = null

    override val elements = mutableListOf<Int>()
    override val capacity = 0
    override var size = 0
    override fun isEmpty() = true

    override fun push(i: Int) = throw Overflow()

    override fun pop() = throw Underflow()

}
