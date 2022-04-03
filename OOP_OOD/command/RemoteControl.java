package command;

public class RemoteControl {
	private Command[] commands;
	private Command undoComand;
	public RemoteControl(int capacity) {
		commands=new Command[capacity];
		for(int i=0;i<capacity;i++) {
			commands[i]=new NoCommand();
		}
		undoComand=new NoCommand();
	}
	
	public void undo() {
		undoComand.undo();
	}
	public void setCommand(int button, Command command) {
		commands[button]=command;
	}
	
	public void press(int button) {
		commands[button].execute();
		undoComand=commands[button];
	}
}
