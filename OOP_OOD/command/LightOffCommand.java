package command;

public class LightOffCommand implements Command{
	private Light light;
	private String prevMode;
	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		prevMode=light.getMode();
		light.off();
	}

	@Override
	public void undo() {
		String temp=light.getMode();
		light.setMode(prevMode);
		prevMode=temp;
	}

}
