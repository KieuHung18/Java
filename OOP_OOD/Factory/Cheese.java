package Factory;

public class Cheese extends Decorate{
	public Cheese(Pizza pizza) {
		super(pizza);
		cost=1.4;
		description="with cheese ";
	}

}
