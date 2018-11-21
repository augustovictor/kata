package kata2

class ZeroCapacityStack: IStack {
    override val capacity: Int = 0
    override var size = 0
    override var elements: Array<Int?> = arrayOf()

    override fun push(value: Int) = throw Overflow()
    override fun top(): Int = throw Empty()

    override fun pop(): Int = throw Underflow()

    override fun isEmpty(): Boolean = true

}
