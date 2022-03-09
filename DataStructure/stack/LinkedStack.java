package stack;
import linkedList.Node;
public class LinkedStack <E>implements MyStack<E>{
	private Node<E>header;
	private Node<E>trailer;
	private int size;
	public LinkedStack() {
		this.header = new Node<>(null, null, null);
		this.trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public E pop() {
		E result =peek();
		Node<E> node =header.getNext();
		node.getNext().setPrev(header);
		header.setNext(node.getNext());
		node.setElement(null);
		node.setPrev(null);
		node.setNext(null);
		size--;
		return result;
	}
	@Override
	public E peek() {
		if(isEmpty()) {throw new StackException("Stack is empty");}
		return header.getNext().getElement();
	}
	@Override
	public void push(E element) {
		Node<E> newNode =new Node<E>(element, header, header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public void clear() {
		while(!isEmpty()) {pop();}
		size=0;
	}
	@Override
	public String toString() {
		if(isEmpty()) {return "[]";}
		String result ="[";
		Node<E> node =header.getNext();
		while(!node.getNext().equals(trailer)) {
			result+=node.getElement()+",";
			node=node.getNext();
		}
		return result+trailer.getPrev().getElement()+"]";
	}
	
}
