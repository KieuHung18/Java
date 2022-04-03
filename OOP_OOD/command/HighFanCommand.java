package command;

public class HighFanCommand implements Command{
	private int prevSpeed;
	private Fan fan;
	
	public HighFanCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void execute() {
		prevSpeed=fan.getSpeed();
		fan.high();
	}

	@Override
	public void undo() {
		int temp = fan.getSpeed();
		fan.setSpeed(prevSpeed);
		prevSpeed = temp;
	}

}
