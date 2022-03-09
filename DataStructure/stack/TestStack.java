package stack;

public class TestStack {
	// reference to class Recursion 
	public static <E>void reversePrint(E[] list) {
		LinkedStack<E> stack=new LinkedStack<>();
		for(int i=0;i<list.length;i++) {
			stack.push(list[i]);
		}
		System.out.println(stack.toString());
	}
	public static void printIntToBinary(int input) {
		 //sign bit
		int signBit;
		if(input>0) {signBit=0;}else{signBit=1;}
		LinkedStack<Integer> stack=new LinkedStack<>();
		while(input!=0) {
			stack.push(Math.abs(input%2));
			input/=2;
		}
		stack.push(signBit);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	public static void test(int i) {i++;}
public static void main(String[] args) {
	System.out.println("ARRAY STACK");
	ArrayStack<Integer> arrStack=new ArrayStack<>();
	arrStack.push(1);arrStack.push(3);arrStack.push(2);
	System.out.println("Stack: "+arrStack.toString());
	System.out.println("Pop: "+arrStack.pop());
	System.out.println("New Stack: "+arrStack.toString());
	
	System.out.println("\nLINKED STACK");
	LinkedStack<Integer> lnkStack =new LinkedStack<>();
	lnkStack.push(1);lnkStack.push(3);lnkStack.push(2);
	System.out.println("Stack: "+lnkStack.toString());
	
	System.out.println("Pop: "+lnkStack.pop());
	System.out.println("New Stack: "+lnkStack.toString());
	lnkStack.clear();
	System.out.println("Clear Stack"+lnkStack.toString());
	
	System.out.println("\nREVERSE PRINT");
	Integer[] iList= {1,2,3,4,5,6};
	reversePrint(iList);
	
	System.out.println("\nTO BINARY");
	printIntToBinary(-13);
}
}
