package command;

public class OffFanCommand implements Command{
	private int prevSpeed;
	private Fan fan;
	
	public OffFanCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void execute() {
		prevSpeed=fan.getSpeed();
		fan.off();
	}

	@Override
	public void undo() {
		int temp = fan.getSpeed();
		fan.setSpeed(prevSpeed);
		prevSpeed = temp;
	}

}
