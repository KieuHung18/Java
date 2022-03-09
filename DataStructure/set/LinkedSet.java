package set;


import java.util.NoSuchElementException;
import java.util.Random;

import iterator.LinkedIterator;
import iterator.MyIterator;
import linkedList.Node;

public class LinkedSet<E> implements MySet<E>{
	private Node<E>header;
	private Node<E>trailer;
	private int size;
	public LinkedSet() {
		header =new Node<E>(null, null, null);
		trailer =new Node<E>(null, header, null);
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
		if(index<0||index>=size) {throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length "+size);}
		return true;
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
	
	@Override
	public void add(E element) {
		if(!contain(element)) {
			Node<E> newNode = new Node<>(element, trailer.getPrev(), trailer);
			trailer.getPrev().setNext(newNode);
			trailer.setPrev(newNode);
			size++;
		}
	}
	
	@Override
	public void addAll(MySet<E> set) {
		MyIterator<E> iterator=set.iterator();
		while(iterator.hasNext()) {
			add(iterator.next());
		}
	}
	
	@Override
	public E removeRandom() {
		Node<E> remove =getNode(new Random().nextInt(size));
		return remove(remove.getElement());
	}
	
	@Override
	public E remove(E element) {
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
	
	@Override
	public MySet<E> union(MySet<E> set) {
		LinkedSet<E> result =new LinkedSet<>();
		result.addAll(this);
		result.addAll(set);
		return result;
	}
	
	@Override
	public boolean contain(E element) {
		Node<E>node=header;
		if(element==null) {
			while(!node.getNext().equals(trailer)) {
				node=node.getNext();
				if(node.getElement()==null) {
					return true;
				}
			}
		}else {
			while(!node.getNext().equals(trailer)) {
				node=node.getNext();
				if(node.getElement()!=null&&node.getElement().equals(element)) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public MyIterator<E> iterator() {
		return new Iter();
	}
	
	@Override
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

	@Override
	public boolean equals(MySet<E> set) {
		if(size==set.size()) {
			MyIterator<E> iterator=set.iterator();
			while(iterator.hasNext()) {
				if(!contain(iterator.next())) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	class Iter extends LinkedIterator<E>{

		public Iter() {
			super(header);
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			super.remove();
			size--;
		}
		
	}
}
