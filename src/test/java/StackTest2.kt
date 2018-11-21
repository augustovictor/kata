import kata2.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StackTest2 {

    private lateinit var stack: IStack

    @Before
    fun setup() {
        stack = BoundedStack.make(2)
    }

    @Test
    fun `newly created stacks should be empty`() {
        assertTrue(BoundedStack.make().isEmpty())
    }

    @Test
    fun `should increase size when pushed`() {
        stack.push(1)
        assertEquals(1, stack.size)
    }

    @Test
    fun `should decrease size when pushed and popped`() {
        stack.push(1)
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun `should have size of 2 when pushed twice`() {
        stack.push(1)
        stack.push(1)
        assertEquals(2, stack.size)
    }

    @Test
    fun `when 1 is pushed 1 should be popped`() {
        stack.push(8)
        assertEquals(8, stack.pop())
    }

    @Test
    fun `when 3 and 4 are pushed 4 and 3 should be popped`() {
        stack.push(3)
        stack.push(4)

        assertEquals(4, stack.pop())
        assertEquals(3, stack.pop())
    }

    @Test(expected = Overflow::class)
    fun `should throw Overflow when push more than capacity`() {
        stack.push(1)
        stack.push(1)
        stack.push(1)
    }

    @Test(expected = Underflow::class)
    fun `pop should throw Underflow when stack is empty`() {
        BoundedStack.make().pop()
    }

    @Test(expected = IllegalSize::class)
    fun `should throw IllegalSize when negative size`() {
        BoundedStack.make(-1)
    }

    @Test
    fun `should create a ZeroCapacityStack when capacity is 0`() {
        val zeroStack = BoundedStack.make()
        assertEquals(ZeroCapacityStack::class.java.name, zeroStack::class.java.name)
    }

    @Test(expected = Overflow::class)
    fun `empty list should throw Overflow when pushed`() {
        BoundedStack.make().push(20)
    }

    @Test(expected = Empty::class)
    fun `should throw Empty when called top on empty stack`() {
        val zeroStack = BoundedStack.make()
        zeroStack.top()
    }

    @Test
    fun `when pushed 3 and 4 should return 4 when called top`() {
        stack.push(3)
        stack.push(4)
        assertEquals(4, stack.top())
    }
}