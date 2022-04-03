package Stratergy;

public class TestStatergy {
public static void main(String[] args) {
	Duck redHead =new RedHeadDuck();
	redHead.display();
	redHead.swim();
	redHead.fly();
	redHead.quack();
	System.out.println();
	Duck robotDuck =new RobotDuck();
	robotDuck.display();
	robotDuck.swim();
	robotDuck.fly();
	robotDuck.quack();
	System.out.println();
	Duck decoyDuck =new DecoyDuck();
	decoyDuck.display();
	decoyDuck.swim();
	decoyDuck.fly();
	decoyDuck.quack();
	System.out.println();
	Duck rubberDuck =new RubberDuck();
	rubberDuck.display();
	rubberDuck.swim();
	rubberDuck.fly();
	rubberDuck.quack();
	System.out.println();
}
}
