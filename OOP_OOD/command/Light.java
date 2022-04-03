package command;

public class Light {
	public static final String ON="on";
	public static final String DIM="dim";
	public static final String OFF="off";
	private String mode=OFF;
	public void on() {
		mode="on";
		System.out.println("Light: "+mode);
	};
	public void off() {
		mode="off";
		System.out.println("Light: "+mode);
	}
	public  void dim() {
		mode="dim";
		System.out.println("Light: "+mode);
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
}
