package stack;

public class ArrayStack<E> implements MyStack<E>{
	private E[]items;
	private int top;
	private static final int CAPACITY=20;
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		this.items = (E[]) new Object[capacity];
		top=-1;
	}
	
	public boolean isFull() {
		return top==items.length-1;
	}
	
	@Override
	public int size() {
		return this.top+1;
	}
	
	@Override
	public E pop() {
			E result=peek();
			items[top]=null;
			top--;
			return result;
	}
	
	@Override
	public E peek() {
		try {
			return items[top];
		} catch (IndexOutOfBoundsException e) {
			throw new StackException("Stack is empty");
		}
	}
	
	@Override
	public void push(E element) {
		try {
			top++;
			items[top]=element;
		} catch (Exception e) {
			throw new StackException("Stack is full");
		}
	}
	
	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	
	@Override
	public void clear() {
		this.items = (E[]) new Object[items.length];
		top=-1;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {return "[]";}
		String result ="[";
		for(int i=0;i<size()-1;i++) {
			result+=items[i]+",";
		}
		// TODO Auto-generated method stub
		return result+items[size()-1]+"]";
	}
}
