package Factory;

public class NewYorkFactory extends Factory{
	
	@Override
	public Pizza createPizza(int type) {
		switch (type) {
		case Factory.DEFAULT_PIZZA:
			return new Veggie(new Sausage(new Cheese(new PlainPizza())));
		case Factory.PINEAPPLE_PIZZA:
			return new Pineapple(new Sausage(new Cheese(new PlainPizza())));
		case Factory.FULL_DECORATE_PIZZA:
			return new Veggie(new Sausage(new Cheese(new Pineapple(new PlainPizza()))));
		default:
			System.out.println("pizza not available here");
		}
		return null;
	}
}
