package Observer;

import java.util.ArrayList;
import java.util.Random;

public class WeatherData implements MyObservable {
	private ArrayList<MyObserver> observer;
	private float humidity;
	private float pressure;
	private float tempature;
	
	public WeatherData() {
		observer =new ArrayList<>();
	}
	
	final float getHumidity() {
		return humidity;
	}


	final float getPressure() {
		return pressure;
	}


	final float getTempature() {
		return tempature;
	}


	@Override
	public void setChange() {
		humidity = new Random().nextFloat()*100;
		pressure = new Random().nextFloat()*100;
		tempature = new Random().nextFloat()*100;
		notifyObserver();
	}

	@Override
	public void deleteObserver(MyObserver o) {
		this.observer.remove(o);
	}

	@Override
	public void addObserver(MyObserver o) {
		this.observer.add(o);
	}

	@Override
	public void notifyObserver() {
		for(MyObserver o: observer) {
			o.update();
		}
	}

}
