package queue;

public interface MyQueue <E>{
public boolean isEmpty();
public int size();
public void enqueue(E element);
public E first();
public E dequeue();
public void clear();
}
