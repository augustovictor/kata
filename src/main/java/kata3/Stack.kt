package kata3

class Stack private constructor(override val capacity: Int) : IStack {

    companion object Factory {
        fun make(capacity: Int): IStack {
            if (capacity == 0) return ZeroCapacityStack()
            return Stack(capacity)
        }
    }

    override var size: Int = 0

    var topElement: Int? = null
        get() = field

    override fun push(i: Int) {
        increaseSize()
        topElement = i
    }

    override fun pop(): Int {
        decreaseSize()
        return topElement!!
    }

    fun increaseSize() {
        if (size == capacity) throw Overflow()
        size++
    }

    override fun top(): Int? {
        return topElement
    }

    fun decreaseSize() {
        if (isEmpty()) throw Underflow()
        size--
    }

    override fun isEmpty() = size == 0

}

class Overflow: RuntimeException()
class Underflow: RuntimeException()