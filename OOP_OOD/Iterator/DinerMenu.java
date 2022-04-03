package Iterator;

public class DinerMenu implements Menu{
	private MenuItem[]itemsList;
	private int size;
	
	public DinerMenu(int capacity) {
		this.itemsList = new MenuItem[capacity];
		size=0;
	}

	@Override
	public void add(MenuItem menuItem) {
		try {
			itemsList[size]=menuItem;
			size++;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Maximun capacity");
		}
	}

	@Override
	public void remove(MenuItem menuItem) {
		for(int i=0;i<size;i++){
			if(itemsList[i].getName().equals(menuItem.getName())&&
				itemsList[i].getCost()==menuItem.getCost()) {
				shiftToLeft(i+1);
				itemsList[size-1]=null;
				size--;
			}
		}
	}
	private void shiftToLeft(int pos) {
		for(int i=pos;i<size;i++) {
			itemsList[i-1]=itemsList[i];
		}
	}
	
	@Override
	public MenuIterator iterator() {
		return new DinerIterator(size, itemsList);
	}

	@Override
	public void print() {
		String result="DINER MENU\n";
		MenuIterator menuIterator =iterator();
		while(menuIterator.hasNext()) {
			result+=menuIterator.next()+"\n";
		}
		System.out.println(result);
	}

}
