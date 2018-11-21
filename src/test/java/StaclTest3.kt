import kata3.*
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class StaclTest3 {

    private lateinit var stack: IStack

    @Mock
    private lateinit var stackMock: Stack

    @Before
    fun setUp() {
        stack = Stack.make(2)
    }

    @Test fun `should push number to stack`() {
        val stack = stack
        stack.push(1)
    }

    @Test fun `should increase size when pushed`() {
        stack.push(1)
        assertEquals(1, stack.size)
    }

    @Test fun `should call increaseSize() once when pushed`() {
        `when`(stackMock.push(1)).thenCallRealMethod()

        stackMock.push(1)
        verify(stackMock, times(1)).increaseSize()
    }

    @Test fun `should increase size to 2 when pushed twice`() {
        stack.push(1)
        stack.push(1)
        assertEquals(2, stack.size)
    }

    @Test(expected = Overflow::class) fun `should throw Overflow when pushed over capacity`() {
        val stackSize1 = Stack.make(1)
        stackSize1.push(1)
        stackSize1.push(1)
    }

    @Test fun `should call decreaseSize once when popped`() {
        `when`(stackMock.topElement).thenReturn(1)
        `when`(stackMock.pop()).thenCallRealMethod()

        stackMock.pop()
        verify(stackMock, times(2)).decreaseSize()
    }

    @Test fun `should decrease size when popped`() {
        stack.push(1)
        stack.pop()
        assertEquals(0, stack.size)
    }

    @Test(expected = Underflow::class)
    fun `should throw Underflow when stack size is 0 and popped`() {
        val stackZeroCapacity = Stack.make(0)
        stackZeroCapacity.pop()
    }

    @Test
    fun `should return 1 when 1 pushed and popped`() {
        stack.push(6)
        assertEquals(6, stack.pop())
    }

    @Test
    fun `should call isEmpty() when decreaseSize() is called`() {
        `when`(stackMock.pop()).thenCallRealMethod()
        `when`(stackMock.decreaseSize()).thenCallRealMethod()

        stackMock.pop()
        verify(stackMock, times(1)).isEmpty()
    }

    @Test
    fun `should create a ZeroCapacityStack when stack created with capacity 0`() {
        val zeroStack = Stack.make(0)
        assertThat(zeroStack, instanceOf(ZeroCapacityStack::class.java))
    }

    @Test
    fun `should return 1 on top when 1 pushed`() {
        stack.push(1)
        assertEquals(1, stack.top())
    }

    @Test(expected = Overflow::class)
    fun `should throw Overflow when top called on empty stack`() {
        val zeroStack = Stack.make(0)
        zeroStack.top()
    }
}