package Factory;

public class TestFactory {
	public static void main(String[] args) {
		Factory NYFactory=new NewYorkFactory();
		Store NYStore =new Store("New York City", NYFactory);
		Pizza pizza= NYStore.order(Factory.DEFAULT_PIZZA);
		System.out.println(pizza.getCost());
		System.out.println(pizza.getDescription());
	}
}
