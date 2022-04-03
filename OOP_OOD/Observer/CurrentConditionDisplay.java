package Observer;

public class CurrentConditionDisplay extends Display{
	@Override
	public void display() {
		super.display();
		System.out.println("Condition: [Humidity: "+humidity+", Tempature: "+tempature+", Pressure: "+pressure+"]");
	}
}
