package Adapter;

public class Quack implements Quackable{
	@Override
	public void quack() {
		System.out.println("quack");
	}

}
