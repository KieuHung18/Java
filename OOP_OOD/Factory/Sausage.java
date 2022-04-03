package Factory;

public class Sausage extends Decorate{

	public Sausage(Pizza pizza) {
		super(pizza);
		cost=1.2;
		description="with sausage ";
	}
}
