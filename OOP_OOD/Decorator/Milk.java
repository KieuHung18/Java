package Decorator;

public class Milk extends Decorate{
	public Milk(Beverage beverage) {
		super(beverage);
		cost=1.2;
		description="with milk ";
	}
	
	@Override
	public double getCost() {
		return super.getCost()+beverage.getCost();
	}
	
	@Override
	public String getDescription() {
		String desc=beverage.getDescription()+super.getDescription();
		return desc;
	}
}
