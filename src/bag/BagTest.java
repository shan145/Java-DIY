package bag;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BagTest {
	@Test
	void testArrayBagMethods() {
		BagInterface<Integer> arrayBag = new ArrayBag<Integer>();
		assertTrue(arrayBag.isEmpty());
		assertEquals(arrayBag.getCurrentSize(), 0);
		
		arrayBag.add(0);
		arrayBag.add(1);
		arrayBag.add(2);
		arrayBag.add(3);
		arrayBag.add(3);
		arrayBag.add(4);
		arrayBag.add(4);
		assertEquals(arrayBag.getCurrentSize(), 7);
		
		assertTrue(arrayBag.contains(0));
		assertEquals(arrayBag.getFrequencyOf(0), 1);
		
		assertTrue(arrayBag.contains(1));
		assertEquals(arrayBag.getFrequencyOf(1), 1);
		
		assertTrue(arrayBag.contains(2));
		assertEquals(arrayBag.getFrequencyOf(2), 1);
		
		assertTrue(arrayBag.contains(3));
		assertEquals(arrayBag.getFrequencyOf(3), 2);
		
		assertTrue(arrayBag.contains(4));
		assertEquals(arrayBag.getFrequencyOf(4), 2);
		
		arrayBag.remove();
		arrayBag.remove();
		assertTrue(!arrayBag.contains(4));
		assertEquals(arrayBag.getFrequencyOf(4), 0);
		
		arrayBag.remove(3);
		assertEquals(arrayBag.getFrequencyOf(3), 1);
		
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
		assertEquals(linkedBag.getCurrentSize(), 7);
		
		assertTrue(linkedBag.contains(0));
		assertEquals(linkedBag.getFrequencyOf(0), 1);
		
		assertTrue(linkedBag.contains(1));
		assertEquals(linkedBag.getFrequencyOf(1), 1);
		
		assertTrue(linkedBag.contains(2));
		assertEquals(linkedBag.getFrequencyOf(2), 1);
		
		assertTrue(linkedBag.contains(3));
		assertEquals(linkedBag.getFrequencyOf(3), 2);
		
		assertTrue(linkedBag.contains(4));
		assertEquals(linkedBag.getFrequencyOf(4), 2);
		
		linkedBag.remove();
		linkedBag.remove();
		assertTrue(!linkedBag.contains(4));
		assertEquals(linkedBag.getFrequencyOf(4), 0);
		
		linkedBag.remove(3);
		assertEquals(linkedBag.getFrequencyOf(3), 1);
		
		linkedBag.clear();
		assertTrue(linkedBag.isEmpty());
	}
}
