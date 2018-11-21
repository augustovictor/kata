import mystack.*
import mystack.exceptions.Empty
import mystack.exceptions.IllegalCapacity
import mystack.exceptions.Overflow
import mystack.exceptions.Underflow
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class StackTest {
    private lateinit var stack: StackInterface

    @Before
    fun setup() {
        stack = BoundedStack.make(2)
    }

    @Test
    fun `newly created stacks should be empty`() {
        assertTrue(stack.isEmpty())
        assertEquals(0, stack.size)
    }

    @Test
    fun `after one push stack size should be one`() {
        stack.push(1)
        assertEquals(1, stack.size)
    }

    @Test
    fun `after two pushes the size should be two`() {
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.size)
    }

    @Test
    fun `after one push and one pop the stack should be empty`() {
        stack.push(1)
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test(expected = Overflow::class)
    fun `when pushed past limit stack overflows`() {
        stack.push(1)
        stack.push(1)
        stack.push(1)
    }

    @Test(expected = Underflow::class)
    fun `when empty stack is popped should throw underflow`() {
        stack.pop()
    }

    @Test
    fun `when one is pushed one is popped`() {
        stack.push(1)
        assertEquals(1, stack.pop())
    }

    @Test
    fun `when one and two are pushed two and one are popped`() {
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

    @Test(expected = IllegalCapacity::class)
    fun `when creating stack with negative size should throw IllegalCapacity`() {
        BoundedStack.make(-1)
    }

    @Test
    fun `should create a ZeroCapacityStack when capacity is zero`() {
        val zeroStack = BoundedStack.make(0)
        IsInstanceOf.instanceOf<ZeroCapacityStack>(zeroStack::class.java)
    }

    @Test
    fun `when one is pushed one should be on top`() {
        stack.push(1)
        assertEquals(1, stack.top())
    }

    @Test(expected = Empty::class)
    fun `when stack is empty top throws empty`() {
        stack.top()
    }

    @Test(expected = Empty::class)
    fun `zero capacity stack should throw empty exception on top`() {
        BoundedStack.make(0).top()
    }

    @Test
    fun `given stack with one and two pushed find one and two`() {
        stack.push(1)
        stack.push(2)
        assertEquals(1, stack.find(1))
        assertEquals(0, stack.find(2))
    }

    @Test
    fun `should return null if find fails`() {
        assertNull(stack.find(2))
    }
}