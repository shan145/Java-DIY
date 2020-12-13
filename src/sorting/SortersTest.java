package sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortersTest {

	@Test
	void testSelectionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Sorters.selectionSort(array, 0, array.length-1);
		for(int i = 0; i < array.length; i++) {
			assertEquals(i+1, array[i]);
		}
	}

	@Test
	void testRecursiveSelectionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Sorters.recursiveSelectionSort(array, 0, array.length-1);
		for(int i = 0; i < array.length; i++) {
			assertEquals(i+1, array[i]);
		}
	}

	@Test
	void testInsertionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Sorters.insertionSort(array, 0, array.length-1);
		for(int i = 0; i < array.length; i++) {
			assertEquals(i+1, array[i]);
		}
	}

}
