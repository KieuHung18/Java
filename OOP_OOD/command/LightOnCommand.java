package command;

public class LightOnCommand implements Command{
	private Light light;
	private String prevMode;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		prevMode=light.getMode();
		light.on();
	}
	@Override
	public void undo() {
		String temp=light.getMode();
		light.setMode(prevMode);
		prevMode=temp;
	}

}
