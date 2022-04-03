package Iterator;

public class TestIterator {
	public static void main(String[] args) {
		CoffeeMenu coffee =new CoffeeMenu();
		
		MenuItem houseBlend = new MenuItem("House Blend", 1.1f);
		MenuItem darkRoast = new MenuItem("Dark Roast ", 1.2f);
		
		coffee.add(houseBlend);
		coffee.add(darkRoast);
		
		coffee.print();
		
		DinerMenu diner =new DinerMenu(10);
		
		MenuItem waffles = new MenuItem("Waffles", 5.5f);
		MenuItem reuben = new MenuItem("Reuben ", 5.6f);
		
		diner.add(waffles);
		diner.add(reuben);
		
		diner.print();
	}
}
