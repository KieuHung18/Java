package command;

public class LowFanCommand implements Command{
	private int prevSpeed;
	private Fan fan;
	
	public LowFanCommand(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		prevSpeed=fan.getSpeed();
		fan.low();
	}

	@Override
	public void undo() {
		int temp = fan.getSpeed();
		fan.setSpeed(prevSpeed);
		prevSpeed = temp;
	}

}
