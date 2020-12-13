package sorting;

public class Sorters {
	
	/*
	 * Selection Sorts (iterative and recursive)
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] array, int start, int end) {
		for(int index = start; index <= end; index++) {
			int indexOfSmallest = getIndexOfNextSmallest(array, index, end);
			swap(array, index, indexOfSmallest);
		}
	}
	
	public static <T extends Comparable<? super T>> void recursiveSelectionSort(T[] array, int start, int end) {
		if (start < end) {
			int indexOfSmallest = getIndexOfNextSmallest(array, start, end);
			swap(array, start, indexOfSmallest);
			recursiveSelectionSort(array, start+1, end);
		}
	}
	
	public static <T extends Comparable<? super T>> int getIndexOfNextSmallest(T[] array, int index, int end) {
		T min = array[index];
		int indexOfMin = index;
		for(int i = index+1; i <= end; i++) {
			if(array[i].compareTo(min) < 0) {
				min = array[i];
				indexOfMin = i;
			}
		}
		return indexOfMin;
	}
	
	public static <T> void swap (T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	/*
	 * Insertion Sorts (iterative and recursive)
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] array, int start, int end) {
		for(int index = start+1; index <= end; index++) {
			T nextToInsert = array[index];
			insertInOrder(nextToInsert, array, start, index);
		}
	}
	
	public static <T extends Comparable<? super T>> void insertInOrder(T nextToInsert, T[] array, int start, int currentIndex) {
		while((currentIndex > start) && ((nextToInsert.compareTo(array[currentIndex-1])) < 0)) {
			array[currentIndex] = array[currentIndex-1];
			currentIndex--;
		}
		array[currentIndex] = nextToInsert;
	}
	
}
