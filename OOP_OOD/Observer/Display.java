package Observer;

public class Display implements MyObserver{
	protected float humidity;
	protected float pressure;
	protected float tempature;
	protected WeatherData weatherData;
	public void display() {
		
	}
	
	public void register(WeatherData w) {
		this.weatherData=w;
		w.addObserver(this);
	}
	
	public void unregister() {
		this.weatherData.deleteObserver(this);
	}
	
	@Override
	public void update() {
		this.humidity=weatherData.getHumidity();
		this.pressure=weatherData.getPressure();
		this.tempature=weatherData.getTempature();
	}
}
