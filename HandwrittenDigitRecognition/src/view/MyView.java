package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import object.Button;
public class MyView extends JPanel{
	int size=10;
	int row;int col;
	double[]activation;
public MyView(int row, int col) {
		this.row = row;
		this.col = col;
		
	}
private Button teach,clear,identify,test;
@Override
public void paint(Graphics g) {
	// TODO Auto-generated method stub
	super.paint(g);
	for(int tmp=0;tmp<=col;tmp++) {
		
		g.drawLine(tmp*size, 0, tmp*size, row*size);
	}
	for(int tmp=0;tmp<=row;tmp++) {
		g.drawLine(0, tmp*size, col*size, tmp*size);
	}
	teach =new Button("Teach", 0, 280, 80, 40);
	drawButton(g,teach);
	clear=new Button("Clear", 90, 280, 80, 40);
	drawButton(g,clear);
	identify=new Button("Identify", 180, 280, 80, 40);
	drawButton(g,identify);
	test=new Button("Test", 0, 330, 80, 40);
	drawButton(g,test);
	if(activation!=null) {
		int x=0;int y=0;
		for(double activation:activation) {
			g.setColor(new Color(0, 0, 0, (float)activation));g.fillRect(x, y, size, size);
			x+=size;
			if(x==size*col) {y+=size;x=0;}
		}
	}
}

public void drawButton(Graphics g,Button button) {
	g.drawRect(button.getX(), button.getY(), button.getW(), button.getH());
	g.drawString(button.getName(), button.getX()+button.getW()/2, button.getY()+button.getH()/2);
}
public Button getTest() {
	return test;
}
public Button getClear() {
	return clear;
}
public Button getIdentify() {
	return identify;
}
public Button getTeach() {
	return teach;
}
public void update(double[] activation) {
	this.activation=activation;
	repaint();
}
public int getRow() {
	return row;
}
public int getCol() {
	return col;
}
public int getsize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
}
