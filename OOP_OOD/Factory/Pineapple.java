package Factory;

public class Pineapple extends Decorate{

	public Pineapple(Pizza pizza) {
		super(pizza);
		cost=1.3;
		description="with pineapple ";
	}

}
