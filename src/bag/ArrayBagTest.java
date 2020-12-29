package bag;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayBagTest {
	@Test
	void testBagMethods() {
		ArrayBag<Integer> arrayBag = new ArrayBag<Integer>();
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
}
