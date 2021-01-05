package bag;

import java.util.Arrays;

public final class ArrayBag<T> implements BagInterface<T> {

	private T[] bag;
	private int numberOfEntries;
	
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		this.bag = tempBag;
		this.numberOfEntries = 0;
		this.initialized = true;
	}
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		if(isArrayFull()) {
			doubleCapacity();
		}
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	}

	@Override
	public T remove() {
		checkInitialization();
		T result = null;
		if(numberOfEntries > 0) {
			result = bag[numberOfEntries-1];
			bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return result.equals(anEntry);
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int frequency = 0;
		for(T entry: bag) {
			if(anEntry.equals(entry)) {
				frequency++;
			}
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1;
	}
	
	private T removeEntry(int givenIndex) {
		T result = null;
		if(!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries-1];
			
			bag[givenIndex] = null;
			numberOfEntries--;
		}
		return result;
	}
	
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean stillLooking = true;
		int index = 0;
		
		while(stillLooking && (index < numberOfEntries)) {
			if(anEntry.equals(bag[index])) {
				stillLooking = false;
				where = index;
			}
			index++;
		}
		return where;
	}
	
	private boolean isArrayFull() {
		return numberOfEntries == bag.length;
	}
	
	private void checkInitialization() {
		if(!this.initialized) {
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}
	
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		bag = Arrays.copyOf(bag, newLength);
	}
}
