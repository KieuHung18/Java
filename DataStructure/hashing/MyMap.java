package hashing;

import set.MySet;

public interface MyMap <K,V>{
	public V put(K key, V value);
	public void putAll(MyMap<K, V>map);
	public V remove(K key);
	public V get(K key);
	public boolean containKey(K key);
	public boolean containValue(V value);
	public MySet<K> keySet();
	public MySet<MyEntry<K,V>> entrySet();
	public int size();
	interface MyEntry<K,V>{
		public void setKey(K key);
		public void setValue(V value);
		public K getKey();
		public V getValue();
		@Override
		boolean equals(Object obj);
		String toString();
	}
}
