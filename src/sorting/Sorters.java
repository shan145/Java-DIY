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
	 * Merge Sorts (Recursive)
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
			if(array[mid].compareTo(array[mid+1]) > 0) merge(array, tempArray, start, mid, end);
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
	
	/*
	 * Quick Sort (Recursive)
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] array, int start, int end) {
		if (end > start) {
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex-1);
			quickSort(array, pivotIndex+1, end);
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] array, int start, int end) {
		T pivot = array[start];
		int low = start + 1;
		int high = end;
		
		while (high > low) {
			while(low <= high && array[low].compareTo(pivot) <= 0) low++;
			while(low <= high && array[high].compareTo(pivot) > 0) high--;
			if(high > low) {
				swap(array, low, high);
			}
		}
		
		// Since pivot is at start in our case, we move it down until it reaches the starting pivot
		while (high > start && array[high].compareTo(pivot) >= 0) high--;
		
		// Swap pivot with array[high]
		if(pivot.compareTo(array[high]) > 0) {
			array[start] = array[high];
			array[high] = pivot;
			return high;
		}
		return start;
	}
	
	public static <T extends Comparable<? super T>> void optimizedQuickSort(T[] array, int start, int end) {
		if(end-start + 1 < 4) { //array is less than 4 entries
			insertionSort(array, start, end);
		}
		else {
			int pivotIndex = optimizedPartition(array, start, end);
			optimizedQuickSort(array, start, pivotIndex-1);
			optimizedQuickSort(array, pivotIndex+1, end);
		}
	}
	
	//Assumes array has at least 4 entries
	private static <T extends Comparable<? super T>> int optimizedPartition(T[] array, int start, int end) {
		int mid = (start+end)/2;
		sortFirstMiddleLast(array, start, mid, end);
		swap(array, mid, end-1);
		
		int pivotIndex = end-1;
		T pivot = array[pivotIndex];
		
		int indexFromLeft = start+1;
		int indexFromRight = end-2;
		boolean done = false;
		
		while(!done) {
			// Move up until we find an entry bigger than/equal to pivot
			while (array[indexFromLeft].compareTo(pivot) < 0) indexFromLeft++;
			// Move down until we find an entry lesser than/equal to pivot
			while (array[indexFromRight].compareTo(pivot) > 0) indexFromRight--;
			
			if (indexFromLeft < indexFromRight) {
				// Swap entries around pivot
				swap(array, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			} else {
				done = true;
			}
		}
		
		swap(array, indexFromLeft, pivotIndex);
		pivotIndex = indexFromLeft;
		return pivotIndex;
	}
	
	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] array, int start, int mid, int end) {
		//Compare start & mid and switch appropriately
		if(array[start].compareTo(array[mid]) > 0) swap(array, start, mid);
		
		//Compare mid & end and switch appropriately
		if(array[mid].compareTo(array[end]) > 0) swap(array, mid, end);
		
		//Compare new start & new mid and switch appropriately
		if(array[start].compareTo(array[mid]) > 0) swap(array, start, mid);
	}
	
	private static <T> void swap (T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
