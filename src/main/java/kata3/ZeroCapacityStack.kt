package kata3

class ZeroCapacityStack : IStack {
    override val capacity: Int = 0
    override var size: Int = 0

    override fun push(i: Int) = throw Overflow()
    override fun top(): Int? = throw Overflow()

    override fun pop(): Int = throw Underflow()

    override fun isEmpty(): Boolean = true

}
