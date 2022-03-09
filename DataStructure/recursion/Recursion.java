package recursion;

public class Recursion {
	public static void reversePrint(int[] list,int firstIndex) {
		if(firstIndex==list.length-1) {
			System.out.print(list[firstIndex]+" | ");
		}
		else {
			reversePrint(list, firstIndex+1);
			System.out.print(list[firstIndex]+" | ");
		}
	}
	public static void printIntToBinary(int input) {
		 //sign bit
		if(Math.abs(input)<2) {
			if(input<0) {
				System.out.print("1"+(Math.abs(input%2)));
			}else {
				System.out.print("0"+(input%2));
			}
		}else {
			printIntToBinary(input/2);
			System.out.print(Math.abs(input%2));
		}
		
	}
	public static <E extends Comparable<E>> boolean symmetricalArray(E[] e,int fristIndex) {
		if(fristIndex==e.length/2) {
			return true;
		}
		else {
			if(e[fristIndex].compareTo(e[e.length-fristIndex-1])!=0) {
				return false;
			}
			else{
				return symmetricalArray(e, fristIndex+1);
			}
		}
	}
	 public static void main(String[] args) {
		reversePrint(new int[] {1,2,3,4,5}, 0);
		System.out.println();
		printIntToBinary(-13);
		System.out.println();
		Double i[]= {2.2,1.5,2.0,1.5,2.2};
		System.out.println(
				Recursion.<Double>symmetricalArray(i,0)
				);
	 }
}
