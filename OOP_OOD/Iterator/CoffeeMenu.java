package Iterator;

import java.util.ArrayList;

public class CoffeeMenu implements Menu{
	private ArrayList<MenuItem> itemsList;

	public CoffeeMenu() {
		this.itemsList = new ArrayList<>();
	}

	@Override
	public void add(MenuItem menuItem) {
		itemsList.add(menuItem);
	}

	@Override
	public void remove(MenuItem menuItem) {
		if(!itemsList.remove(menuItem)) {
			System.out.println("item not found");
		};
	}

	@Override
	public MenuIterator iterator() {
		// TODO Auto-generated method stub
		return new CoffeeIterator(itemsList.size(), itemsList);
	}

	@Override
	public void print() {
		String result="COFFEE MENU\n";
		MenuIterator menuIterator =iterator();
		while(menuIterator.hasNext()) {
			result+=menuIterator.next()+"\n";
		}
		System.out.println(result);
	}
	
	
}
