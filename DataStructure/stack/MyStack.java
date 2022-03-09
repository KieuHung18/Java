package stack;

public interface MyStack <E>{
	public int size();
	public E pop();
	public E peek();
	public void push(E element);
	public boolean isEmpty();
	public void clear();
}
