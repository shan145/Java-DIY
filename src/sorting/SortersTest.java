package sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortersTest {

	@Test
	void testSelectionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Integer[] expectedArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Sorters.selectionSort(array, 0, array.length-1);
		assertTrue(Arrays.equals(expectedArray, array));
		
		Integer[] array2 = new Integer[] {9, 5, 4, 2, 6};
		Integer[] expectedArray2 = new Integer[] {9, 2, 4, 5, 6};
		Sorters.selectionSort(array2, 1, array2.length-2);
		assertTrue(Arrays.equals(expectedArray2, array2));
	}

	@Test
	void testRecursiveSelectionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Integer[] expectedArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Sorters.recursiveSelectionSort(array, 0, array.length-1);
		assertTrue(Arrays.equals(expectedArray, array));
		
		Integer[] array2 = new Integer[] {9, 5, 4, 2, 6};
		Integer[] expectedArray2 = new Integer[] {9, 2, 4, 5, 6};
		Sorters.recursiveSelectionSort(array2, 1, array2.length-2);
		assertTrue(Arrays.equals(expectedArray2, array2));
		
	}

	@Test
	void testInsertionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Integer[] expectedArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Sorters.insertionSort(array, 0, array.length-1);
		assertTrue(Arrays.equals(expectedArray, array));
		
		Integer[] array2 = new Integer[] {9, 5, 4, 2, 6};
		Integer[] expectedArray2 = new Integer[] {9, 2, 4, 5, 6};
		Sorters.insertionSort(array2, 1, array2.length-2);
		assertTrue(Arrays.equals(expectedArray2, array2));
	}
	
	@Test
	void testRecursiveInsertionSort() {
		Integer[] array = new Integer[] {9, 1, 3, 4, 2, 8, 6, 5, 7};
		Integer[] expectedArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Sorters.recursiveInsertionSort(array, 0, array.length-1);
		assertTrue(Arrays.equals(expectedArray, array));
		
		Integer[] array2 = new Integer[] {9, 5, 4, 2, 6};
		Integer[] expectedArray2 = new Integer[] {9, 2, 4, 5, 6};
		Sorters.recursiveInsertionSort(array2, 1, array2.length-2);
		assertTrue(Arrays.equals(expectedArray2, array2));
	}

}
