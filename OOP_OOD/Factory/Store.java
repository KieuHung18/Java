package Factory;

public class Store {
	private String address;
	private Factory factory;
	public Store(String address, Factory factory) {
		super();
		this.address = address;
		this.factory = factory;
	}

	public Pizza order(int type) {
		return factory.createPizza(type);
	}
	
}
