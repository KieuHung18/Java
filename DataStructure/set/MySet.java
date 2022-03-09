package set;

import iterator.MyIterator;

public interface MySet <E>{
public void add (E element);
public void addAll(MySet<E> set);
public E removeRandom();
public E remove(E element);
public MySet<E> union(MySet<E>set);
public boolean contain(E element);
public boolean isEmpty();
public int size();
public MyIterator<E> iterator();
public String toString();
boolean equals(MySet<E> set);
}
