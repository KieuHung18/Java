package iterator;

import java.util.NoSuchElementException;

public class ArrayIterator<E> implements MyIterator<E>{
	private E[]items;
	private int size;
	private int current;
	public ArrayIterator(E[] items,int size) {
		super();
		this.items = items;
		this.size = size;
		this.current = -1;
	}
	@Override
	public E next() {
		if(!hasNext()) {throw new NoSuchElementException();}
		current++;
		return items[current];
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current<size-1;
	}
	@Override
	public void remove() {
		try {
			for(int i=current;i<size-1;i++) {
				items[i]=items[i+1];
			}
			items[size-1]=null;
			current--;
			size--;
		} catch (Exception e) {
			throw new IllegalStateException();
			// TODO: handle exception
		}
	}
	@Override
	public String toString() {
		if(size==0) {return "[]";}
		String result="[";
		for(int i=0;i<size-1;i++) {
			result+=items[i]+",";
		}
		return result+items[size-1]+"]";
	}
}
