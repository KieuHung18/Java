package linkedList;

import java.util.Comparator;
import java.util.NoSuchElementException;

import iterator.LinkedIterator;
import iterator.MyIterator;

public class DoublyLinkedList <E>{
	private Node<E>header;
	private Node<E>trailer;
	private int size;
	public DoublyLinkedList() {
		this.header = new Node<>(null, null, null);
		this.trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	private Node<E> getNode(int index){
		if(checkIndex(index)) {
			Node<E> node =header.getNext();
			for(int i=0;i<=index;i++) {
				if(i==index) {
					return node;
				}
				node=node.getNext();
			}
		}
		throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length "+size);
	}
	private boolean checkIndex(int index) {
		return index>0||index<size;
	}
	private Node<E> getNode(E element){
		Node<E>node=header.getNext();
		if(element==null) {
			while(node.getNext()!=null) {
				if(node.getElement()==null) {
					return node;
				}
				node=node.getNext();
			}
		}else {
			while(node.getNext()!=null) {
				if(node.getElement()!=null&&node.getElement().equals(element)) {
					return node;
				}
				node=node.getNext();
			}
		}
		throw new NoSuchElementException();
	}
	
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public E getFirst() {
		if(isEmpty()) {throw new NoSuchElementException();}
		return header.getNext().getElement();
	}
	
	public E getLast() {
		if(isEmpty()) {throw new NoSuchElementException();}
		return trailer.getPrev().getElement();
	}
	
	public int indexOf(E element) {
		Node<E>node=header.getNext();
		if(element==null) {
			for(int i=0;i<size;i++) {
				if(node.getElement()==null) {
					return i;
				}
				node=node.getNext();
			}
		}else {
			for(int i=0;i<size;i++) {
				if(node.getElement()!=null&&node.getElement().equals(element)) {
					return i;
				}
				node=node.getNext();
			}
		}
		throw new NoSuchElementException();
	}
	
	public E get(int index) {
		return getNode(index).getElement();
	}
	
	public void addFirst(E element) {
		Node<E> newNode = new Node<>(element, header, header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}
	
	public void addLast(E element) {
		Node<E> newNode = new Node<>(element, trailer.getPrev(), trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		size++;
	}
	
	public void add(int index,E element){
		Node<E>node=getNode(index);
		Node<E> newNode = new Node<>(element, node.getPrev(), node);
		node.getPrev().setNext(newNode);
		node.setPrev(newNode);
		size++;
	}
	
	public E removeIndex(int index) {
		return removeElement(getNode(index).getElement());
	}
	
	public E removeElement(E element) {
		Node<E> remove =getNode(element);
		E result =remove.getElement();
		remove.getPrev().setNext(remove.getNext());
		remove.getNext().setPrev(remove.getPrev());
		
		remove.setElement(null);
		remove.setNext(null);
		remove.setPrev(null);
		size--;
		
		return result;
	}
	
	public void Set(int index, E newValue) {
		getNode(index).setElement(newValue);
	}
	
	 /* SelectionSort Sort
     * take every node from this list to result 
     * Not create new Node
     * Not destroy Node
     * Not change Node value
     * Note moving Node in same list
     * result is new sorted list
     * this list will be empty
     */
	public DoublyLinkedList<E> Sort(Comparator<E> comparator) {	
		DoublyLinkedList<E> result=new DoublyLinkedList<>();
			while(!isEmpty()) {
				Node<E>min=findMin(comparator,header.getNext());
				min.getNext().setPrev(min.getPrev());
				min.getPrev().setNext(min.getNext());
				this.size--;
				min.setNext(result.trailer);
				min.setPrev(result.trailer.getPrev());
				result.trailer.getPrev().setNext(min);
				result.trailer.setPrev(min);
				result.size++;
			}
		return result;
	}
	private Node<E> findMin(Comparator<E> comparator,Node<E> start) {
		Node<E>min = start;
		while(!start.getNext().equals(trailer)) {
			start=start.getNext();
			if(comparator.compare(min.getElement(), start.getElement())>0) {min=start;};
		}
		return min;
	}
	
	public int size() {
		return this.size;
	}
	public String toString() {
		if(isEmpty()) {return"[]";}
		String result ="[";
		Node<E>node=header.getNext();
		while(!node.getNext().equals(trailer)) {
			result+=String.valueOf(node.getElement())+",";
			node=node.getNext();
		}
		return result+trailer.getPrev().getElement()+"]";
	}
	public MyIterator<E> iterator(){
		return new Iter();
	}
	class Iter extends LinkedIterator<E>{
		public Iter() {
			super(header);
		}
		@Override
		public void remove() {
			super.remove();
			size--;
		}
	}
}