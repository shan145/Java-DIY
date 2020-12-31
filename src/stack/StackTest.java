package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testLinkedStackMethods() {
		StackInterface<Integer> linkedStack = new LinkedStack<Integer>();
		
		assertTrue(linkedStack.isEmpty());
		linkedStack.push(0);
		assertEquals(linkedStack.peek(), 0);
		
		linkedStack.push(1);
		assertEquals(linkedStack.peek(), 1);

		linkedStack.push(1);
		linkedStack.push(2);
		linkedStack.push(3);
		assertEquals(linkedStack.peek(), 3);
		assertEquals(linkedStack.pop(), 3);
		assertEquals(linkedStack.peek(), 2);
		assertEquals(linkedStack.pop(), 2);
		assertEquals(linkedStack.peek(), 1);
		
		linkedStack.clear();
		assertTrue(linkedStack.isEmpty());
	}

}
