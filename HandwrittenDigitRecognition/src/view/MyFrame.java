package view;


import javax.swing.JFrame;

import object.Action;
import object.Button;

public class MyFrame extends JFrame {
	private MyView myView =new MyView(28, 28);
	public static final int WIDTH=281,HEIGHT=400;
 public MyFrame() {
	 	setUndecorated(true);
	 	getContentPane().add(myView);
	 	setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
	// TODO Auto-generated constructor stub
}
public Action ButtonListener(int x,int y) {
	if(impact(x, y, myView.getTeach())) {return Action.Teach;}
	if(impact(x, y, myView.getClear())) {return Action.Clear;}
	if(impact(x, y, myView.getIdentify())) {return Action.Identify;}
	if(impact(x, y, myView.getTest())) {return Action.Test;}
	return null;
	
}

public boolean impact(int x,int y,Button button) {
	if((x>=button.getX()&&x<=button.getX()+button.getW()&&y>=button.getY()&&y<=button.getY()+button.getH())) {
		return true;}return false;
}
public MyView getMyView() {
	return myView;
}
}
