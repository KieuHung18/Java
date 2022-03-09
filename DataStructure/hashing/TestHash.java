package hashing;

import set.LinkedSet;

public class TestHash {
	public static void main(String[] args) {
	MyHashMap<String, Integer> hashMap=new MyHashMap<>();
	hashMap.put(null, null);
	hashMap.put("0", 1);
	hashMap.put("1", 1);
	hashMap.put("2", 2);
	hashMap.put("3", 3);
	hashMap.put("3", 3);
	hashMap.put("3", 3);
	System.out.println("HM1: "+hashMap.toString());
	System.out.println(
	"contain key 3: "+hashMap.containKey("3")+"\n"+
	"contain value null: "+hashMap.containValue(null));
	System.out.println("remove: "+hashMap.remove("3"));
	System.out.println("remove: "+hashMap.remove("2"));
	System.out.println("remove: "+hashMap.remove("1"));
	System.out.println("HM1: "+hashMap.toString());
	
	System.out.println("put K:1|V:2");hashMap.put("1", 2);
	System.out.println("put K:1|V:3");hashMap.put("1", 3);
	System.out.println("put K:0|V:2");hashMap.put("0", 2);
	System.out.println("HM1: "+hashMap.toString());
	
	
	MyHashMap<String, Integer> hashMap2=new MyHashMap<>();
	hashMap2.put("4", 4);
	hashMap2.put("5", 5);
	hashMap2.put("1", 2);
	System.out.println("HM2: "+hashMap2.toString()+"+");
	System.out.println("HM1: "+hashMap.toString());
	
	hashMap.putAll(hashMap2);
	System.out.println("HM1+HM2: \n"+hashMap.toString());
	}
}