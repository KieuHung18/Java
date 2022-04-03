package MVC;

import java.util.ArrayList;

public class CalculateModel implements Model{
	private double result;
	private ArrayList<MyObserver> observers;
	
	public CalculateModel() {
		observers=new ArrayList<>();
	}
	@Override
	public double add(double first, double sec) {
		result=first+sec;
		return result;
	}

	@Override
	public double multiply(double first, double sec) {
		// TODO Auto-generated method stub
		result=first*sec;
		return result;
	}

	@Override
	public double divide(double first, double sec) {
		// TODO Auto-generated method stub
		result=first/sec;
		return result;
	}

	@Override
	public double subtract(double first, double sec) {
		// TODO Auto-generated method stub
		result=first-sec;
		return result;
	}
	public void reset() {
		result=0;
	}
	@Override
	public void setChange() {
		notifyObserver();
	}
	
	@Override
	public void deleteObserver(MyObserver o) {
		observers.remove(o);
	}

	@Override
	public void addObserver(MyObserver o) {
		observers.add(o);
	}

	@Override
	public void notifyObserver() {
		for(int i=0;i<observers.size();i++) {
			observers.get(i).update();
		}
	}

	@Override
	public double getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
