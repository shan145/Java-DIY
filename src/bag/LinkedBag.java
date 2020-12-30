package bag;

public final class LinkedBag<T> implements BagInterface<T>{
	private Node headNode;
	private int numberOfEntries;
	
	public LinkedBag() {
		headNode = null;
		numberOfEntries = 0;
	}
	
	private class Node {
		private T data;
		private Node next;
		
		private Node(T data) {
			this(data, null);
		}
		
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		private T getData() {
			return this.data;
		}
		
		private void setData(T data) {
			this.data = data;
		}
		
		private Node getNextNode() {
			return this.next;
		}
		
		private void setNextNode(Node next) {
			this.next = next;
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
		Node newNode = new Node(newEntry); //Add to beginning
		newNode.setNextNode(headNode);
		headNode = newNode;
		
		return true;
	}

	@Override
	public T remove() {
		T result = null;
		if(headNode != null) {
			result = headNode.getData();
			headNode = headNode.getNextNode();
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		return true;
	}

	@Override
	public void clear() {
		this.headNode = null;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int index = 0;
		Node currentNode = headNode;
		while((index < numberOfEntries) && currentNode != null) {
			if(anEntry.equals(currentNode.getData())) {
				frequency++;
			}
			index++;
			currentNode = currentNode.getNextNode();
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		Node currentNode = headNode;
		while(currentNode != null) {
			if(anEntry.equals(currentNode.getData())) {
				return true;
			}
		}
		return false;
	}

}
