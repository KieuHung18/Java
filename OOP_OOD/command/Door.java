package command;

public class Door {
	public static String CLOSE="close";
	public static String OPEN="open";
	private String state=CLOSE;
	public void open() {
		state=OPEN;
		System.out.println(state);
	}
	public void close() {
		state=CLOSE;
		System.out.println(state);
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
