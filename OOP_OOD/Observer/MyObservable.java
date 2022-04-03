package Observer;

public interface MyObservable {
public void setChange();
public void deleteObserver(MyObserver o);
public void addObserver(MyObserver o);
public void notifyObserver();
}
