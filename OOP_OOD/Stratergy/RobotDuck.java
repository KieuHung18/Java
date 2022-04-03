package Stratergy;

public class RobotDuck extends Duck{
	public RobotDuck() {
		setQuackable(new Quack());
		setFlyable(new RocketFly());
		setSwimable(new SwimEngine());
	}
	@Override
	public void display() {
		super.display();
		System.out.println("robot duck");
	}
}
