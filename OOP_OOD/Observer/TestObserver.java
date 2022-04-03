package Observer;

public class TestObserver {
 public static void main(String[] args) {
	WeatherData weatherData =new WeatherData();
	Display forcecast =new WeatherForecastDisplay();
	forcecast.register(weatherData);
	Display condition =new CurrentConditionDisplay();
	condition.register(weatherData);
	
	weatherData.setChange();
	forcecast.display();
	condition.display();
}
}
