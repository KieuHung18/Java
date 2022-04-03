package Decorator;

public class TestDecorate {
	public static void main(String[] args) {
		Beverage beverage=new Milk(new Whip(new HouseBlend()));
		System.out.println(beverage.getDescription());
		System.out.println(beverage.getCost());
	}
}
