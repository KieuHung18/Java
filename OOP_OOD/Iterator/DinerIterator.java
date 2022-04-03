package Iterator;

public class DinerIterator implements MenuIterator{
	private MenuItem[]itemsList;
	private int size,current;
	public DinerIterator(int size,MenuItem[]itemsList) {
		this.size = size;
		this.current = -1;
		this.itemsList=itemsList;
	}

	@Override
	public boolean hasNext() {
	return current!=size-1;
	}
	
	@Override
	public MenuItem next() {
		try {
			current++;
			return itemsList[current];
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No item left");
		}
		return null;
	}

}
