package generic;

public class Pair <A,B>{
	A first;
	B second;
	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}
	public A getFirst() {
		return first;
	}
	public B getSecond() {
		return second;
	}
	public double max(Pair<Double,Double> stack) {
		return 0;
	}
	public void setFirst(A first) {
		this.first = first;
	}
	public void setSecond(B second) {
		this.second = second;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+first+","+second+")";
	}
}
