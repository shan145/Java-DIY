package bag;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BagTest {
	@Test
	void testArrayBagMethods() {
		BagInterface<Integer> arrayBag = new ArrayBag<Integer>();
		assertTrue(arrayBag.isEmpty());
		assertEquals(0, arrayBag.getCurrentSize());
		
		arrayBag.add(0);
		arrayBag.add(1);
		arrayBag.add(2);
		arrayBag.add(3);
		arrayBag.add(3);
		arrayBag.add(4);
		arrayBag.add(4);
		arrayBag.add(5);
		arrayBag.add(5);
		arrayBag.add(6); 
		
		assertEquals(10, arrayBag.getCurrentSize());
		
		arrayBag.add(6); 
		assertEquals(11, arrayBag.getCurrentSize()); //Test if resizing works properly (default capacity is 10)
		
		assertTrue(arrayBag.contains(0));
		assertEquals(1, arrayBag.getFrequencyOf(0));
		
		assertTrue(arrayBag.contains(1));
		assertEquals(1, arrayBag.getFrequencyOf(1));
		
		assertTrue(arrayBag.contains(2));
		assertEquals(1, arrayBag.getFrequencyOf(2));
		
		assertTrue(arrayBag.contains(3));
		assertEquals(2, arrayBag.getFrequencyOf(3));
		
		assertTrue(arrayBag.contains(4));
		assertEquals(2, arrayBag.getFrequencyOf(4));
		
		assertTrue(arrayBag.contains(5));
		assertEquals(2, arrayBag.getFrequencyOf(5));
		
		assertTrue(arrayBag.contains(6));
		assertEquals(2, arrayBag.getFrequencyOf(6));
		
		arrayBag.remove();
		arrayBag.remove();
		assertTrue(!arrayBag.contains(6));
		assertEquals(0, arrayBag.getFrequencyOf(6));
		
		arrayBag.remove(3);
		assertEquals(1, arrayBag.getFrequencyOf(3));
		
		arrayBag.clear();
		assertTrue(arrayBag.isEmpty());
		
	}
	
	@Test
	void testLinkedBagMethods() {
		BagInterface<Integer> linkedBag = new LinkedBag<Integer>();
		assertTrue(linkedBag.isEmpty());
		assertEquals(linkedBag.getCurrentSize(), 0);
		
		linkedBag.add(0);
		linkedBag.add(1);
		linkedBag.add(2);
		linkedBag.add(3);
		linkedBag.add(3);
		linkedBag.add(4);
		linkedBag.add(4);
		assertEquals(7, linkedBag.getCurrentSize());
		
		assertTrue(linkedBag.contains(0));
		assertEquals(1, linkedBag.getFrequencyOf(0));
		
		assertTrue(linkedBag.contains(1));
		assertEquals(1, linkedBag.getFrequencyOf(1));
		
		assertTrue(linkedBag.contains(2));
		assertEquals(1, linkedBag.getFrequencyOf(2));
		
		assertTrue(linkedBag.contains(3));
		assertEquals(2, linkedBag.getFrequencyOf(3));
		
		assertTrue(linkedBag.contains(4));
		assertEquals(2, linkedBag.getFrequencyOf(4));
		
		linkedBag.remove();
		linkedBag.remove();
		assertTrue(!linkedBag.contains(4));
		assertEquals(0, linkedBag.getFrequencyOf(4));
		
		linkedBag.remove(3);
		assertEquals(1, linkedBag.getFrequencyOf(3));
		
		linkedBag.clear();
		assertTrue(linkedBag.isEmpty());
	}
}
