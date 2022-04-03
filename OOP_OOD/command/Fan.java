package command;

public class Fan {
	public static final int HIGH=3;
	public static final int MED=2;
	public static final int LOW=1;
	public static final int OFF=0;
	private int speed=OFF;
	public void high () {
		speed=3;
		System.out.println("Speed: "+speed);
	}
	public void med () {
		speed=2;
		System.out.println("Speed: "+speed);
	}
	public void low() {
		speed=1;
		System.out.println("Speed: "+speed);
	}
	public void off () {
		speed=0;
		System.out.println("Speed: "+speed);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
	
	
