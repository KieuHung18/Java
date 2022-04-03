package Iterator;

import java.util.ArrayList;

public class CoffeeIterator implements MenuIterator{
	private int current;
	private ArrayList<MenuItem> itemsList;
	
	public CoffeeIterator(int size, ArrayList<MenuItem> itemsList) {
		this.current = -1;
		this.itemsList=itemsList;
	}

	@Override
	public boolean hasNext() {
		return current!=itemsList.size()-1;
	}

	@Override
	public MenuItem next() {
		try {
			current++;
			return itemsList.get(current);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No item left");
		}
		return null;
	}

}
