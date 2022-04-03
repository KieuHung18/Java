package Decorator;

public class Whip extends Decorate{
	public Whip(Beverage beverage) {
		super(beverage);
		cost=1.5;
		description="with whip ";
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
