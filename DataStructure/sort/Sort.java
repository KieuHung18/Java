package sort;

public class Sort {
	public <E extends Comparable<E>> E[] InterchangeSort(E[]list){
		E temp;
		for(int i=0;i<list.length-1;i++) {
			for(int j=i+1;j<list.length;j++) {
				if(list[j].compareTo(list[i])<0) {
					temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
		return list;
	}
	
	public <E extends Comparable<E>> E[] SelectionSort(E[]list){
		E min;int minIndex;
		for(int i=0;i<list.length-1;i++) {
			min=list[i];minIndex=i;
			for(int j=i+1;j<list.length;j++) {
				if(list[j].compareTo(min)<0) {min=list[j];minIndex=j;}
			}
			list[minIndex]=list[i];
			list[i]=min;
		}
		return list;
	}
	
	public <E extends Comparable<E>> E[] InsertionSort(E[]list){
		E temp;
		for(int i=1;i<list.length;i++) {
			for(int j=0;j<i;j++) {
				if(list[i].compareTo(list[j])<0) {
					temp=list[i];
					for(int pos=i;pos>j;pos--) {
						list[pos]=list[pos-1];
					}
					list[j]=temp;
					break;
				}
			}
		}
		return list;
	}
	
	public <E extends Comparable<E>> E[] BubbleSort(E[]list){
		E temp;
		for(int i=0;i<list.length-1;i++) {
			for(int j=list.length-1;j>i;j--) {
				if(list[j].compareTo(list[i])<0) {
					temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
		return list;
	}
	
	public <E extends Comparable<E>> E[] QuickSort(E[]list,int firstIndex,int lastIndex){
		int length=(lastIndex-firstIndex)+1,
			i=firstIndex,
			j=lastIndex;
		if(firstIndex==lastIndex) {return list;}
		E pivot=list[firstIndex+length/2],temp;
		while(i<=j) {
			if(list[i].compareTo(pivot)<0) {i++;}
			if(list[j].compareTo(pivot)>0) {j--;}
			if(i<=j) {
				temp=list[i];
				list[i]=list[j];
				list[j]=temp;
				j--;i++;
			}
		}
		if(length>3) {
		QuickSort(list, firstIndex, i-1);
		QuickSort(list,j , lastIndex);
		}
		return list;
	}
	
	public<E> String toString(E[]list) {
		String result ="";
		for(E e: list) {result+=e+" | ";}
		return result;
	}
public static void main(String[] args) {
//	Integer[] i = {1,5,6,8,7,1,2,9,4};
//	Integer[] i = {9,8,1,7,3,2,15};
	Integer[] i = {1,12,5,26,7,14,3,7,2};
	Sort sort=new Sort();
//	sort.InterchangeSort(i);
//	sort.SelectionSort(i);
//	sort.BubbleSort(i);
//	sort.InsertionSort(i);
	sort.QuickSort(i, 0, i.length-1);
	System.out.println(sort.toString(i));
}
}
