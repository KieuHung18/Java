package command;

public class TestCommand {
	public static final int LIGHT_ON=0;
	public static final int LIGHT_OFF=1;
	public static final int DOOR_CLOSE=2;
	public static final int DOOR_OPEN=3;
	public static final int OFF_FAN=4;
	public static final int LOW_FAN=5;
	public static final int MED_FAN=6;
	public static final int HIGH_FAN=7;
	public static final int GLOBAL_COMMAND=8;
	
	public static void main(String[] args) {
		Light light = new Light();
		Command lightOn= new LightOnCommand(light);
		Command lightOff= new LightOnCommand(light);
		
		Fan fan = new Fan();
		Command offFan= new OffFanCommand(fan);
		Command lowFan= new LowFanCommand(fan);
		Command medFan= new MedFanCommand(fan);
		Command highFan= new HighFanCommand(fan);
		
		Door door = new Door();
		Command closeDoor= new CloseDoorCommand(door);
		Command openDoor= new OpenDoorCommand(door);
		
		MacroCommand global=new MacroCommand(new Command[] {lightOn,openDoor,medFan});
		
		RemoteControl remoteControl = new RemoteControl(9);
		remoteControl.setCommand(LIGHT_ON, lightOn);
		remoteControl.setCommand(LIGHT_OFF, lightOff);
		remoteControl.setCommand(DOOR_CLOSE, closeDoor);
		remoteControl.setCommand(DOOR_OPEN, openDoor);
		remoteControl.setCommand(OFF_FAN, offFan);
		remoteControl.setCommand(LOW_FAN, lowFan);
		remoteControl.setCommand(MED_FAN, medFan);
		remoteControl.setCommand(HIGH_FAN, highFan);
		remoteControl.setCommand(GLOBAL_COMMAND, global);
		
		System.out.println("TEST DOOR");
		remoteControl.press(DOOR_OPEN);
		remoteControl.undo();
		System.out.println(door.getState());
		remoteControl.undo();
		System.out.println(door.getState());
		remoteControl.undo();
		System.out.println(door.getState());
		
		System.out.println("\nTEST MACRO");
		remoteControl.press(GLOBAL_COMMAND);
		System.out.println("\nundo\n");
		remoteControl.undo();
		System.out.println(light.getMode());
		System.out.println(door.getState());
		System.out.println(fan.getSpeed());
		
	}
}
