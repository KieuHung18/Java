package queue;

public class CircularArrayQueue <E> implements MyQueue<E>{
	private E[]items;
	private int queueFront;
	private int queueRear;
	private static final int CAPACITY=20;
	public CircularArrayQueue() {
		this(CAPACITY);
	}
	public CircularArrayQueue(int capacity) {
		this.items = (E[]) new Object[capacity];
		queueFront=0;queueRear=-1;
	}
	public boolean isFull(){
		return size()==items.length;
		
	}
	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public int size() {
		return (queueRear-queueFront)+1;
	}

	@Override
	public void enqueue(E element) {
		if(isFull()) {throw new QueueException("Queue is full");}
		items[(queueFront+size())%items.length]=element;
		queueRear++;
	}

	@Override
	public E first() {
		if(isEmpty()) {throw new QueueException("Queue is empty");}
		return items[queueFront];
	}

	@Override
	public E dequeue() {
		E result =first();
		items[queueFront]=null;
		queueFront++;
		return result;
	}

	@Override
	public void clear() {
		this.items = (E[]) new Object[items.length];
		queueFront=0;queueRear=-1;
		
	}
	@Override
	public String toString() {
		if(isEmpty()) {return "[]";}
		String result="[";
		for(int i=0;i<size()-1;i++) {
			result+=items[i]+",";
		}
		return result+items[size()-1]+"]";
	}
}
