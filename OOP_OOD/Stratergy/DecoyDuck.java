package Stratergy;

public class DecoyDuck extends Duck{
	public DecoyDuck() {
		setQuackable(new NoQuack());
		setFlyable(new NoFly());
		setSwimable(new NoSwim());
	}
	@Override
	public void display() {
		super.display();
		System.out.println("decoy duck");
	}
}
