package iterator;

import java.util.NoSuchElementException;

import linkedList.Node;

public class LinkedIterator<E> implements MyIterator<E>{
	private Node<E>current;
	
	public LinkedIterator(Node<E> header) {
		current=header;
	}
	@Override
	public E next() {
		if(!hasNext()) {throw new NoSuchElementException();}
		current=current.getNext();
		return current.getElement();
	}

	@Override
	public boolean hasNext() {
		return !(current.getNext().getNext()==null);
	}
	
	@Override
	public void remove() {
		if(current.getPrev()==null) {throw new IllegalStateException();}
		current.getPrev().setNext(current.getNext());
		current.getNext().setPrev(current.getPrev());
		current.setElement(null);
		current=current.getPrev();
		// TODO Auto-generated method stub
	}
	@Override
	public String toString() {
		return "Not implement yet";
	}
}
