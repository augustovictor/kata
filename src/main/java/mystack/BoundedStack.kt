package mystack

import mystack.exceptions.Empty
import mystack.exceptions.IllegalCapacity
import mystack.exceptions.Overflow
import mystack.exceptions.Underflow

class BoundedStack private constructor(override val capacity: Int) : StackInterface {
    override val elements = mutableListOf<Int>()
    override var size = 0

    companion object {
        fun make(capacity: Int): StackInterface {
            if (capacity < 0) throw IllegalCapacity()
            if (capacity == 0) return ZeroCapacityStack()
            return BoundedStack(capacity)
        }
    }

    override fun top(): Int {
        if (isEmpty()) throw Empty()
        return elements[size-1]
    }

    override fun find(element: Int): Int? {
        val indexSize = size -1
        for (i in indexSize  downTo 0)
            if (element == elements[i]) return indexSize -i
        return null
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun push(i: Int) {
        if (size == capacity) throw Overflow()
        elements.add(size++, i)
    }

    override fun pop(): Int {
        if (isEmpty()) throw Underflow()
        return elements[--size]
    }

}