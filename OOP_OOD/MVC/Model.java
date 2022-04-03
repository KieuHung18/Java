package MVC;

public interface Model {
	public double add(double first,double sec);
	public double multiply(double first,double sec);
	public double divide(double first,double sec);
	public double subtract(double first,double sec);
	public double getResult();
	
	public void setChange();
	public void deleteObserver(MyObserver o);
	public void addObserver(MyObserver o);
	public void notifyObserver();
}
