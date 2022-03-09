package array;

import java.util.Comparator;
import java.util.NoSuchElementException;

import iterator.ArrayIterator;
import iterator.MyIterator;

public class MyArray <E>{
	private E[]items;
	private int size;
	private static final int CAPACITY=20;
	private static final int EXPAND=CAPACITY/2;
	public MyArray() {
		this(CAPACITY);
	}
	
	public MyArray(int capacity) {
		this.items = (E[]) new Object[capacity];
		size=0;
	}
	
	/**
     * Shifts the element currently at the first position (if any) and
     * any subsequent elements to the right (adds specified element to the first index).
     */
	public void addFirst(E element){
		if(isFull()) {expand();}
		size++;
		shiftToRight(0);
		items[0]=element;
	}
	
	/**
     * adds specified element to the last index
     */
	public void addLast(E element){
		if(isFull()) {expand();}
		size++;
		items[size-1]=element;
		
	}
	
	/**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     */
	public void add(int index,E element){
		if(isFull()) {expand();}
		size++;
		shiftToRight(index);
		items[index]=element;
	}
	
	/**
     * Shifts the element currently at that position and
     * any subsequent elements to the right.
     */
	private void shiftToRight(int pos) {
		for(int i=size-1;i>pos;i--) {
			items[i]=items[i-1];
		}
	}
	
	/**
     * Shifts the element currently at that position and
     * any subsequent elements to the left.
     * Replace the element ahead of that position
     */
	private void shiftToLeft(int pos) {
		for(int i=pos;i<size;i++) {
			items[i-1]=items[i];
		}
	}
	
	/**
     * increase capacity by 10
     */
	private void expand() {
		E tmp[]=items;
		items=(E[])new Object[items.length+EXPAND];
		for(int i=0;i<tmp.length;i++) {
			items[i]=tmp[i];
		}
	}
	
	public void set(int index,E value) {
		if(checkIndex(index)) {
		items[index]=value;
		}
		throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length "+size);
	}
	
	public E removeIndex(int index) {
		if(checkIndex(index)) {
		E result=items[index];
		removeElement(get(index));
		return result;
		}
		throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length "+size);
	}
	
	public E removeElement(E element) {
		shiftToLeft(indexOf(element)+1);
		items[size-1]=null;
		size--;
		return element;
	}
	
	public E get(int index) {
		if(checkIndex(index)) {
			return items[index];
		}
		throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length "+size);
	}
	
	public E getFirst() {
		if(isEmpty()) {throw new NoSuchElementException();}
		return items[0];}
	
	public E getLast() {
		if(isEmpty()) {throw new NoSuchElementException();}
		return items[size-1];}
	
	public int indexOf(E element) {
		if(element==null) {
			for(int i=0;i<size;i++) {
				if(items[i]==null) {
					return i;
				}
			}
		}
		else{
			for(int i=0;i<size;i++) {
				if(items[i]!=null&&items[i].equals(element)) {
					return i;
				}
			}
		}
		throw new NoSuchElementException();
	}
	
	private boolean isFull() {
		return size==items.length;
	}
	
	public boolean isEmpty() {
		return  size==0;
	}
	
	public int size() {
		return size;
	}
	
	public E[] Sort(Comparator<E> comparator){
		E min;int minIndex;
		for(int i=0;i<items.length-1;i++) {
			min=items[i];minIndex=i;
			for(int j=i+1;j<items.length;j++) {
				if(comparator.compare(items[j], min)<0) {min=items[j];minIndex=j;}
			}
			items[minIndex]=items[i];
			items[i]=min;
		}
		return items;
	}
	
	private boolean checkIndex(int index) {
		return index>0||index<size;
	}
	
	public MyIterator<E> iterator(){
		return new ArrayIterator<>(items, size);
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {return "[]";}
		String result="[";
		for(int i=0;i<size-1;i++) {
			result+=items[i]+",";
		}
		return result+items[size-1]+"]";
	}
	class Iter extends ArrayIterator<E>{
		public Iter() {
			super(items, size);
		}
		@Override
		public void remove() {
			super.remove();
			size--;
		}
		
	}
}
