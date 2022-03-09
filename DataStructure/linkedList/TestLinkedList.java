package linkedList;

import java.util.ArrayList;

public class TestLinkedList {
	public static void main(String[] args) {
		new  ArrayList<>().add(0, args);
		DoublyLinkedList<Integer> list=new DoublyLinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addLast(3);
		list.add(2, 4);
		System.out.println(list.toString());
		
	}
}
