package Observer;

public class WeatherForecastDisplay extends Display{
	@Override
	public void display() {
		super.display();
		forceCast();
		System.out.println("Forecast: [Humidity: "+humidity+", Tempature: "+tempature+", Pressure: "+pressure+"]");
	}
	private void forceCast() {
		humidity*=1.1;
		tempature*=1.2;
		pressure*=1.3;
	}
}
