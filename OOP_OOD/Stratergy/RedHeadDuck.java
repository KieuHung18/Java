package Stratergy;

public class RedHeadDuck extends Duck{
	public RedHeadDuck() {
		setQuackable(new Quack());
		setFlyable(new Fly());
		setSwimable(new Swim());
	}
	@Override
	public void display() {
		super.display();
		System.out.println("red head duck");
	}

}
