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
	
	private static <T extends Comparable<? super T>> int getIndexOfNextSmallest(T[] array, int index, int end) {
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
	
	private static <T> void swap (T[] array, int i, int j) {
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
	
	private static <T extends Comparable<? super T>> void insertInOrder(T nextToInsert, T[] array, int start, int currentIndex) {
		while((currentIndex > start) && ((nextToInsert.compareTo(array[currentIndex-1])) < 0)) {
			array[currentIndex] = array[currentIndex-1];
			currentIndex--;
		}
		array[currentIndex] = nextToInsert;
	}
	
	public static <T extends Comparable<? super T>> void recursiveInsertionSort(T[] array, int start, int end) {
		if(start < end) {
			recursiveInsertionSort(array, start, end-1);
			recursiveInsertInOrder(array[end], array, start, end-1);
		}
	}
	
	private static <T extends Comparable<? super T>> void recursiveInsertInOrder(T elementToInsert, T[] array, int start, int end) {
		if (elementToInsert.compareTo(array[end]) >= 0) {
			array[end+1] = elementToInsert;
		}
		else if (start < end) {
			array[end+1] = array[end];
			recursiveInsertInOrder(elementToInsert, array, start, end-1);
		} else {
			array[end+1] = array[end];
			array[end] = elementToInsert;
		}
	}
	
	/*
	 * Merge Sorts (iterative and recursive)
	 */
	public static <T extends Comparable<? super T>> void recursiveMergeSort(T[] array, int start, int end) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[])new Comparable<?>[array.length];
		mergeSort(array, tempArray, start, end);
	}
	
	private static <T extends Comparable<? super T>> void mergeSort(T[] array, T[] tempArray, int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			mergeSort(array, tempArray, start, mid);
			mergeSort(array, tempArray, mid+1, end);
			merge(array, tempArray, start, mid, end);
		}
	}
	
	private static <T extends Comparable<? super T>> void merge(T[] array, T[] tempArray, int start, int mid, int end) {
		int startHalf1 = start;
		int endHalf1 = mid;
		int startHalf2 = mid+1;
		int endHalf2 = end;
		
		int index = start; //index of tempArray where space is available
		
		while((startHalf1 <= endHalf1) && (startHalf2 <= endHalf2)) {
			if(array[startHalf1].compareTo(array[startHalf2]) <= 0) {
				tempArray[index] = array[startHalf1];
				startHalf1++;
			}
			else {
				tempArray[index] = array[startHalf2];
				startHalf2++;
			}
			index++;
		}
		
		// Copy over remaining from other subarray to tempArray
		while(startHalf1 <= endHalf1) {
			tempArray[index] = array[startHalf1];
			startHalf1++;
			index++;
		}
		while(startHalf2 <= endHalf2) {
			tempArray[index] = array[startHalf2];
			startHalf2++;
			index++;
		}
		
		// Copy from tempArray to regular array
		for(int k = start; k <= end; k++) {
			array[k] = tempArray[k];
		}
	}
	
}
