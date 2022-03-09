package set;

import java.util.NoSuchElementException;
import java.util.Random;

import iterator.ArrayIterator;
import iterator.MyIterator;

public class ArraySet<E> implements MySet<E>{
	private E[]items;
	private static final int CAPACITY=16;
	private int size;
	
	public ArraySet() {
		this(CAPACITY);
	}
	
	public ArraySet(int capacity) {
		items =(E[]) new Object[capacity];
		size=0;
	}
	
	public void add(E element) {
		if(!contain(element)) {
			if(isFull()) {expand();}
			size++;
			items[size-1]=element;
		}
	}
	
	private void expand() {
		E oldItems[]=items;
		items=(E[])new Object[items.length*2];
		for(int i=0;i<oldItems.length;i++) {
			items[i]=oldItems[i];
		}
	}
	
	@Override
	public void addAll(MySet<E> set) {
		MyIterator<E>iterator=set.iterator();
		while(iterator.hasNext()) {
			add(iterator.next());
		}
	}

	@Override
	public E removeRandom() {
		if(isEmpty()) {throw new EmptySetException();}
		return remove(items[new Random().nextInt(size)]);
	}
	private void shiftToLeft(int pos) {
		for(int i=pos;i<size;i++) {
			items[i-1]=items[i];
		}
	}
	
	@Override
	public E remove(E element) {
		if(element==null) {
			for(int i=0;i<size;i++) {
				if(items[i]==null) {
					shiftToLeft(i+1);
					items[size-1]=null;
					size--;
					return element;
				}
			}
		}
		else{
			for(int i=0;i<size;i++) {
				if(items[i]!=null&&items[i].equals(element)) {
					shiftToLeft(i+1);
					items[size-1]=null;
					size--;
					return element;
				}
			}
		}
		
		throw new NoSuchElementException();
	}

	@Override
	public MySet<E> union(MySet<E> set) {
		ArraySet<E> union=new ArraySet<>(size+set.size());
		union.addAll(this);
		union.addAll(set);
		return union;
	}
	
	@Override
	public boolean contain(E element) {
		if(element==null) {
			for(int i=0;i<size;i++) {
				if(items[i]==null) {return true;}
				}
		}else {
			for(int i=0;i<size;i++) {
				if(items[i]!=null&&items[i].equals(element)) {return true;}
			}
		}
		return false;
	}
	
	public boolean isFull() {
		return size==items.length;
	}

	@Override
	public boolean equals(MySet<E> set) {
		if(set.size()==size) {
			MyIterator<E> iterator=set.iterator();
			while(iterator.hasNext()) {
				if(!(contain(iterator.next()))){
					return false;}
			}
			return true;
		}
		return false;
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
	public MyIterator<E> iterator() {
		return new Iter();
	}
	@Override
	public String toString() {
		if(isEmpty()) {return"[]";}
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
