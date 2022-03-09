package hashing;

import java.util.NoSuchElementException;

import iterator.MyIterator;
import linkedList.DoublyLinkedList;
import set.LinkedSet;
import set.MySet;

public class MyHashMap<K,V> implements MyMap<K, V>{
	//SEPARATE CHAINING
	
	/**
	 *  Default capacity 2^4=16
	 */
	private final static int CAPACITY = 16;
	
	/**
	 *  Max capacity 2^30
	 */
	private final static int MAX_CAPACITY = (int) Math.pow(2, 30);
	
	/**
	 *  tracking when to expand if(size>(capacity*load factor))return true
	 */
	private final static double LOAD_FACTOR = 0.75;
	
	/**
	 * List of items each element of this list is a DoublyLinkedList contain a list of entry which have the same hash(key) index
	 * Which mean  each element in this list is a sub list contain a list of entry which have the same hash(key) index
	 */
	private DoublyLinkedList<MyEntry<K, V>>[]items;
	
	/**
	 *  entry set(type: LinkedSet) store all key/value of this map
	 */
	private MySet<MyEntry<K, V>> entrySet;
	
	/**
	 * Default constructor with capacity = 16
	 */
	public MyHashMap() {
		this(CAPACITY);
	}
	
	/**
	 * Constructor with capacity
	 */
	public MyHashMap(int capacity) {
		items=(DoublyLinkedList<MyEntry<K, V>>[])new DoublyLinkedList[capacity];
		entrySet=new LinkedSet<MyMap.MyEntry<K,V>>();
	}
	
	/**
	 * number of entry in this hashMap
	 */
	@Override
	public int size() {return entrySet.size();}
	
	/**
	 * create new items[] with new length and copy all entry from old items[] to the new one
	 * new length will have the length of old length*2
	 */
	public void expand(int entryIndex) {
		int capacity=items.length;
		DoublyLinkedList<MyEntry<K, V>>[] oldItems=items;
		
		if(CAPACITY<MAX_CAPACITY) {
			while(entryIndex>capacity) {
				capacity*=2;
			}
			if(capacity>MAX_CAPACITY) {capacity=MAX_CAPACITY;}
			items=(DoublyLinkedList<MyEntry<K, V>>[])new DoublyLinkedList[capacity];
			
			for(int i=0;i<oldItems.length;i++) {
				items[i]=oldItems[i];
			}
		}
	}
	
	/**
	 * put the entry at index hash(key)
	 * expand if index>=items.length*LOAD_FACTOR
	 * create new entry and return null if entry at key is empty, replace the value of the entry and return it otherwise
	 */
	@Override
	public V put(K key, V value) {
		int index=hash(key);
		if(index>=items.length*LOAD_FACTOR) {expand(index);}
		MyEntry<K, V> entry=newEntry(key, value);
		if(items[index]==null) {
			entrySet.add(entry);
			items[index]=new DoublyLinkedList<MyMap.MyEntry<K,V>>();
			items[index].addLast(entry);
			return null;
		}else {
			MyEntry<K, V> result=findEntry(key);
			result.setValue(value);
			return value;
		}
	}
	
	/**
	 * create newEntry()
	 */
	private MyEntry< K, V>newEntry(K key,V value) {
		return new MyEntry<K,V>() {
			private K k=key;
			private V v=value;
			@Override
			public K getKey() {
				return k;
			}

			@Override
			public V getValue() {
				return v;
			}
			
			@Override
			public boolean equals(Object obj) {
				MyEntry<K, V>entry =(MyEntry<K, V>)obj;
				if(getKey()==entry.getKey()&&getValue()==entry.getValue()||this==obj)
					return true;
				if(	getKey()==null&&entry.getKey()!=null||
					getKey()!=null&&entry.getKey()==null||
					getValue()==null&&entry.getValue()!=null||
					getValue()!=null&&entry.getValue()==null
					)return false;
				
				if(getKey().getClass()!=entry.getKey().getClass()||
						getValue().getClass()!=entry.getValue().getClass()
					)return false;
				
				return getKey().equals(entry.getKey())&&getValue().equals(entry.getValue());
			}
			
			@Override
			public String toString() {
//				return super.toString();
				return "(Key: "+getKey()+","+"Value: "+getValue()+")";
			}

			@Override
			public void setKey(K key) {
				k=key;
			}

			@Override
			public void setValue(V value) { 
				v=value;
			}
		};
	}
	
	/**
	 * return the index of the entry calculate by a hash function
	 */
	public int hash(K key) {
		if(key==null) {return 0;}
		if(key.hashCode()<MAX_CAPACITY) {return key.hashCode();}
		return MAX_CAPACITY-1;
	}
	
	/**
	 * put all entry form the target map to this map
	 * replace this map entry value if have the same key
	 */
	@Override
	public void putAll(MyMap<K, V> map) {
		MyIterator<MyEntry<K, V>> iterator=map.entrySet().iterator();
		MyEntry<K, V>entry;
		while(iterator.hasNext()) {
			entry=iterator.next();
			put(entry.getKey(), entry.getValue());
			
		}
	}
	
	/**
	 * remove the entry at key
	 */
	@Override
	public V remove(K key) {
		MyEntry<K, V> entry=findEntry(key);
		int index=hash(key);
		entrySet.remove(entry);
		items[index].removeElement(entry);
		if(items[index].isEmpty()) {items[index]=null;}
		return entry.getValue();
	}
	
	/**
	 * get the value of the entry at key
	 */
	@Override
	public V get(K key) {
		return findEntry(key).getValue();
	}
	
	/**
	 *  find the entry at key by:
	 * 	- find items[hash(key)]: this will return a sublist of entry have the same hash(key) index
	 * 	 - return the entry have the exact same key value on this sublist
	 */
	private MyEntry<K, V> findEntry(K key){
		if(!containKey(key)){throw new NoSuchElementException();}
		MyIterator<MyEntry<K, V>> iterator=items[hash(key)].iterator();
		MyEntry<K, V> result;
		if(key==null) {
			while(iterator.hasNext()) {
				result=iterator.next();
				if(result.getKey()==null) {
					return result;
				}
			}
		}
		else {
			while(iterator.hasNext()) {
				result=iterator.next();
				if(result.getKey()!=null&&result.getKey().equals(key)) {
					return result;
				}
			}
		}
		return null;
	}
	
	/**
	 *  check if the key exists in the entrySet
	 */
	@Override
	public boolean containKey(K key) {
		return items[hash(key)]!=null;
	}
	
	/**
	 *  check if the value exists in the entrySet
	 */
	@Override
	public boolean containValue(V value) {
		MyIterator<MyEntry<K, V>>iterator=entrySet.iterator();
		MyEntry<K, V> result;
		if(value==null) {
			while(iterator.hasNext()) {
				result=iterator.next();
				if(result.getValue()==null) {return true;}
			}
		}else {
			while(iterator.hasNext()) {
				result=iterator.next();
				if(result.getValue()!=null&&result.getValue().equals(value)) {return true;}
			}
		}
		return false;
	}
	
	/**
	 *  return a set of key (type: LinkedSet)
	 */
	@Override
	public MySet<K> keySet() {
		MyIterator<MyEntry<K, V>>iterator=entrySet.iterator();
		MySet<K>key=new LinkedSet<>();
		while(iterator.hasNext()) {
			key.add(iterator.next().getKey());
		}
		return key;
	}
	
	/**
	 *  return the entrySet (type: LinkedSet)
	 */
	@Override
	public MySet<MyEntry<K, V>> entrySet() {
		return entrySet;
	}
	
	@Override
	public String toString() {
		if(size()==0) {return"[]";}
		String result="[";
		MyIterator<MyEntry<K, V>>iterator=entrySet.iterator();
		MyEntry<K, V> entry;
		while(iterator.hasNext()) {
			entry=iterator.next();
			result+=entry.toString()+"\n";
		}
		return result;
	}
}
