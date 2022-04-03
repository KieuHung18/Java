package Iterator;

public class MenuItem {
	private String name;
	private float cost;
	
	public MenuItem(String name, float cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+", Price: "+cost;
	}

	public String getName() {
		return name;
	}

	public float getCost() {
		return cost;
	}
}
