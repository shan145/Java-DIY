package bag;

public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	private static final int DEFAULT_CAPACITY = 25;
	
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity) {
		if(capacity < MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[])new Object[capacity];
			this.bag = tempBag;
			this.numberOfEntries = 0;
			this.initialized = true;
		} else {
			throw new IllegalStateException("Tried to create bag above max capacity of 10000");
		}
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
		if(numberOfEntries < DEFAULT_CAPACITY) {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
			return true;
		}
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
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
			if(entry.equals(anEntry)) {
				frequency++;
			}
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		return getFrequencyOf(anEntry) != 0;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for(int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
	}
	
	private void checkInitialization() {
		if(!this.initialized) {
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}
	
}
