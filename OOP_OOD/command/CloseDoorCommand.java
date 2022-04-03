package command;

public class 
CloseDoorCommand implements Command{
	private Door door;
	private String prevState;
	

	public CloseDoorCommand(Door door) {
		super();
		this.door = door;
	}

	@Override
	public void execute() {
		prevState = door.getState();
		door.close();
	}

	@Override
	public void undo() {
		String temp = door.getState();
		door.setState(prevState);
		prevState=temp;
	}

}
