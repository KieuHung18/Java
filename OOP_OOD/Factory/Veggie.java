package Factory;

public class Veggie extends Decorate{
public Veggie(Pizza pizza) {
		super(pizza);
		cost=1.1;
		description="with veggie ";
	}
}
