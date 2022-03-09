package search;

import sort.Sort;

public class Search {
	public Search() {
	}
	public <E extends Comparable<E>> int sequentialSearch(E[]list, E value){
		for(int i=0;i<list.length;i++) {
			if(list[i].compareTo(value)==0) {
				return i;
			}
		}
		return -1;
	}
	/*
	 * import sort.Sort;
	 */
	public <E extends Comparable<E>> int binarySearch(E[]list,E value){
		new Sort().QuickSort(list,0,list.length-1);
		int left=0,
			right=list.length-1,
			mid;
		while(left<=right) {
			mid=(left+right)/2;
			if(list[mid].compareTo(value)==0) {return mid;}
			if(list[mid].compareTo(value)>0) {
				right=mid-1;
			}
			if(list[mid].compareTo(value)<0) {
				left=mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Search search=new Search();
		Integer[] i = {1,5,6,8,7,1,2,9,4};
		System.out.println(i[search.sequentialSearch(i, 7)]);
		System.out.println(i[search.binarySearch(i, 7)]);
		
		
		String[]c= {"hi","hello","good","bad"};
//		String a=new String("hello");
		System.out.println(c[search.binarySearch(c, "hello")]);
		System.out.println(c[search.sequentialSearch(c, "hello")]);
	}
}
