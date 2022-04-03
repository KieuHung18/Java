package Iterator;

public interface Menu {
	public void add(MenuItem menuItem);
	public void remove(MenuItem menuItem);
	public MenuIterator iterator();
	public void print();
}
