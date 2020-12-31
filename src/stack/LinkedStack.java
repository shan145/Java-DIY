package stack;

import java.util.EmptyStackException;

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
		
		private Node getNextNode() {
			return this.next;
		}
		
		private void setNextNode(Node next) {
			this.next = next;
		}
	}
	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.setNextNode(headNode);
		headNode = newNode;
	}

	@Override
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		T popResult = headNode.getData();
		headNode = headNode.getNextNode();
		return popResult;
	}

	@Override
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
		T peekResult = headNode.getData();
		return peekResult;
	}

	@Override
	public boolean isEmpty() {
		return headNode == null;
	}

	@Override
	public void clear() {
		headNode = null;
	}
	
}
