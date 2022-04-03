package MVC;

import javax.swing.JPanel;

public interface Controller {
	public void calculate(String first, String sec,String opr);
	public void changeView(int view);
	public void changeOperation(String operation);
}
