package linkedList;

public class Node <E>{
	private E element;
	private Node<E> prev;
	private Node<E> next;
	public Node(E element, Node<E> prev, Node<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	public E getElement() {
		if (next == null || prev == null)
			throw new IllegalStateException(" Invalid Position");
		return element;
		
	}
	public void setElement(E element) {
		if (next == null || prev == null)
			throw new IllegalStateException(" Invalid Position");
		this.element = element;
	}
	public Node<E> getPrev() {
		return prev;
	}
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	
}
