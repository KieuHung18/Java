package Decorator;

public abstract class Decorate extends Beverage{
	protected Beverage beverage;
	public Decorate(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	
}
