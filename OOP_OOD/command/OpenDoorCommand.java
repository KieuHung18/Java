package command;

public class OpenDoorCommand implements Command{
	private Door door;
	private String prevState;
	
	
	public OpenDoorCommand(Door door) {
		super();
		this.door = door;
	}

	@Override
	public void execute() {
		prevState = door.getState();
		door.open();
	}

	@Override
	public void undo() {
		String temp = door.getState();
		door.setState(prevState);
		prevState=temp;
	}
}
