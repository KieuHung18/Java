package iterator;

public class TestIterator {
	public static void main(String[] args) {
		Integer[] i= {1,2,3,4,5,6,7,8};
		ArrayIterator<Integer> e =new ArrayIterator<>(i,i.length);
		e.next();
		e.next();
		e.remove();
		e.remove();
		System.out.println(e.toString());
		while(e.hasNext()) {
			System.out.println(e.next());
		}
	}
}
