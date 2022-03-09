package generic;

public class RaditionalNumber {
private Pair<Integer, Integer> number;
public RaditionalNumber(int numerator,int denominator) {
	this.number = new Pair<Integer,Integer>(numerator,denominator);
}
public Pair<Integer, Integer> getNumber() {
	return number;
}
public void setNumber(int numerator,int denominator) {
	this.number = new Pair<Integer,Integer>(numerator,denominator);
}
public void setNumerator(int number) {
	this.number.setFirst(number);
}
public void setDenominator(int number) {
	this.number.setSecond(number);
}
public RaditionalNumber add(RaditionalNumber secondNum) {
	if(number.getSecond()==secondNum.getNumber().getSecond()) {
		return SortNumber(
			new RaditionalNumber(number.getFirst()+secondNum.getNumber().getFirst(),
						 		 number.getSecond()
						 		)
						);
				
	}
	else {
		return SortNumber(
			new RaditionalNumber(number.getFirst()*secondNum.getNumber().getSecond() + number.getSecond()*secondNum.getNumber().getFirst(),
								 number.getSecond()*secondNum.getNumber().getSecond()
								 )
						);
	}
}
public void setNumber(Pair<Integer, Integer> number) {
	this.number = number;
}
public RaditionalNumber multiply(RaditionalNumber secondNum) {
	return SortNumber(
			new RaditionalNumber(number.getFirst()*secondNum.getNumber().getFirst(),
								 number.getSecond()*secondNum.getNumber().getSecond()
								 )
			);
}
public RaditionalNumber SortNumber(RaditionalNumber number) {
	for(int i=2;i<=9;i++) {
		if(number.getNumber().getFirst()%i==0&&number.getNumber().getSecond()%i==0) {
			number.setNumerator(number.getNumber().getFirst()/i);
			number.setDenominator(number.getNumber().getSecond()/i);
		}
	}
	return number;
}
public String toString() {
	return String.valueOf(this.number.getFirst()+"/"+this.number.getSecond());
}
public static void main(String[] args) {
	RaditionalNumber r=new RaditionalNumber(3, 4);
	RaditionalNumber r2=new RaditionalNumber(2, 3);
	RaditionalNumber r3=new RaditionalNumber(18, 60);
	r.SortNumber(r);
	System.out.println(r.add(r2).toString());
}
}
