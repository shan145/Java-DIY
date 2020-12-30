package stack;

public final class LinkedStack<T> implements StackInterface<T>{
	private Node headNode;
	
	public LinkedStack() {
		headNode = null;
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
		
		private void setNode(Node next) {
			this.next = next;
		}
	}
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
