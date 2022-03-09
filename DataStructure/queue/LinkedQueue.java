package queue;
import linkedList.Node;
public class LinkedQueue <E> implements MyQueue<E>{
	private Node<E>header;
	private Node<E>trailer;
	private int size;
	public LinkedQueue() {
		this.header = new Node<>(null, null, null);
		this.trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void enqueue(E element) {
		Node<E> newNode =new Node<E>(element, header, header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}
	@Override
	public E first() {
		if(isEmpty()) {throw new QueueException("Queue is empty");}
		return trailer.getPrev().getElement();
	}
	@Override
	public E dequeue() {
		E result=first();
		Node<E> node =trailer.getPrev();
		trailer.setPrev(node.getPrev());
		node.getPrev().setNext(trailer);
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return result;
	}
	@Override
	public void clear() {
		while(!isEmpty()) {dequeue();}
		size=0;
	}
	@Override
	public String toString() {
		if(isEmpty()) {return "[]";}
		String result="[";
		Node<E>node =header.getNext();
		while(!node.getNext().equals(trailer)) {
			result+=node.getElement()+",";
			node=node.getNext();
		}
		return result+trailer.getPrev().getElement()+"]";
	}
}
