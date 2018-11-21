package kata2

class BoundedStack private constructor(override val capacity: Int) : IStack {

    override var size: Int = 0
    override var elements = arrayOfNulls<Int>(capacity)

    companion object {
        fun make(capacity: Int = 0): IStack {
            if (capacity < 0) throw IllegalSize()
            if (capacity == 0) return ZeroCapacityStack()
            return BoundedStack(capacity)
        }
    }

    override fun push(value: Int) {
        if (size == capacity) throw Overflow()
        elements[size++] = value
    }

    override fun pop(): Int {
        if (isEmpty()) throw Underflow()
        return elements[--size]!!
    }

    override fun isEmpty() = size == 0
    override fun top(): Int {
        if (isEmpty()) throw Empty()
        return elements[size-1]!!
    }
}

