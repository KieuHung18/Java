package Factory;

public abstract class Decorate extends Pizza{
	protected Pizza pizza;

	public Decorate(Pizza pizza) {
		this.pizza = pizza;
	}
	@Override
	public double getCost() {
		double cost =this.cost+pizza.getCost();
		cost =Math.round(cost*100);
		return cost/100;
	}
	
	@Override
	public String getDescription() {
		String desc =pizza.getDescription()+description;
		return desc;
	}
}
