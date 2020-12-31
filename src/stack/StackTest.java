package stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testLinkedStackMethods() {
		StackInterface<Integer> linkedStack = new LinkedStack<Integer>();
		
		assertTrue(linkedStack.isEmpty());
		linkedStack.push(0);
		assertEquals(0, linkedStack.peek());
		
		linkedStack.push(1);
		assertEquals(1, linkedStack.peek());

		linkedStack.push(1);
		linkedStack.push(2);
		linkedStack.push(3);
		assertEquals(3, linkedStack.peek());
		assertEquals(3, linkedStack.pop());
		assertEquals(2, linkedStack.peek());
		assertEquals(2, linkedStack.pop());
		assertEquals(1, linkedStack.peek());
		
		linkedStack.clear();
		assertTrue(linkedStack.isEmpty());
		assertThrows(EmptyStackException.class, () -> linkedStack.pop());
		assertThrows(EmptyStackException.class, () -> linkedStack.peek());
	}

}
