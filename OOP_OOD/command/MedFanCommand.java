package command;

public class MedFanCommand implements Command{
	private int prevSpeed;
	private Fan fan;
	
	public MedFanCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void execute() {
		prevSpeed=fan.getSpeed();
		fan.med();
	}

	@Override
	public void undo() {
		int temp = fan.getSpeed();
		fan.setSpeed(prevSpeed);
		prevSpeed = temp;
	}
	

}
