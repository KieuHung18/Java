package Adapter;


public class TestAdapter {
	public static void main(String[] args) {
		DuckLike redHead = new RedHeadDuck();
		DogLike husky =new  Husky();
		PettingMachine machine =new PettingMachine();
		
		DuckAdapter duckToDog =new DuckAdapter(redHead);
		
		machine.petting(duckToDog);
	}
}
