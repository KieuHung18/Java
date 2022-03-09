package set;


public class TestSet {
	public static void main(String[] args) {
		System.out.println("ARRAY SET");
		ArraySet<Integer> intSet =new ArraySet<Integer>();
		ArraySet<Integer> intSet2 =new ArraySet<Integer>();
		intSet.add(1);intSet2.add(4);
		intSet.add(2);intSet2.add(2);
		intSet.add(null);intSet2.add(1);
		intSet.add(4);intSet2.add(null);
		System.out.println("intSet: "+ intSet.toString());
		System.out.println("intSet2: "+ intSet2.toString());
		System.out.println("Equal: "+intSet.equals(intSet2));
		
		System.out.println("intSet remove: "+ intSet.remove(2));
		System.out.println("intSet remove random: "+ intSet.removeRandom());
		System.out.println("intSet: "+ intSet.toString());
		
		System.out.println("union intSet & intSet2: "+ intSet.union(intSet2).toString());
		
		System.out.println("add all intSet2 to intSet: ");
		System.out.println("intSet: "+ intSet.toString());
		System.out.println("intSet2: "+ intSet2.toString());
		intSet.addAll(intSet2);
		System.out.println("intSet: "+ intSet.toString());
		
		System.out.println("\nLINKED SET");
		LinkedSet<Integer> lIntSet=new LinkedSet<>();
		LinkedSet<Integer> lIntSet2=new LinkedSet<>();
		lIntSet.add(2);lIntSet2.add(2);
		lIntSet.add(3);lIntSet2.add(5);
		lIntSet.add(null);lIntSet2.add(3);
		lIntSet.add(5);lIntSet2.add(null);
		System.out.println("intSet: "+ lIntSet.toString());
		System.out.println("intSet2: "+ lIntSet2.toString());
		System.out.println(lIntSet.equals(lIntSet2));
		
		System.out.println("intSet remove: "+ lIntSet.remove(2));
		System.out.println("intSet remove random: "+ lIntSet.removeRandom());
		System.out.println("intSet: "+ intSet.toString());
		
		System.out.println("union intSet & intSet2: "+ lIntSet.union(lIntSet2).toString());
		
		System.out.println("add all intSet2 to intSet: ");
		System.out.println("intSet: "+ lIntSet.toString());
		System.out.println("intSet2: "+ lIntSet2.toString());
		lIntSet.addAll(lIntSet2);
		System.out.println("intSet: "+ lIntSet.toString());
	}
	
}
