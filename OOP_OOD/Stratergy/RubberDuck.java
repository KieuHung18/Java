package Stratergy;

public class RubberDuck extends Duck{
	public RubberDuck() {
		setQuackable(new Squish());
		setFlyable(new NoFly());
		setSwimable(new Swim());
	}
	@Override
	public void display() {
		super.display();
		System.out.println("rubber duck");
	}
}
