package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import neural_model.WorkSpace;
import object.Action;
import object.DataBase;
import view.MyFrame;

public class Controler implements MouseInputListener, KeyListener,ActionListener{
private MyFrame myFrame;Scanner sc =new Scanner(System.in);
private WorkSpace workSpace; DataBase db=new DataBase();Timer t=new Timer(1000, this);
private double[][] pixel;
public Controler() {
	 myFrame =new MyFrame();
	 myFrame.addMouseListener(this);
	 myFrame.addMouseMotionListener(this);
	 myFrame.addKeyListener(this);
	 workSpace=new WorkSpace(myFrame.getMyView().getRow(), myFrame.getMyView().getCol());
	
}
int runing,testData;
@Override
public void mousePressed(MouseEvent arg0) {
	Action action;
	action=myFrame.ButtonListener(arg0.getX(), arg0.getY());
	if(action!=null) {switch (action) {
	case Teach:
		System.out.print("Nhap So Luong Data: ");int data=sc.nextInt();
		System.out.print("Nhap So lan Chay: ");int timeRun=sc.nextInt();
		System.out.println("Runing.........");
		workSpace.process(data, timeRun);
		break;
	case Clear:workSpace.reset();workSpace.setActive(false); myFrame.getMyView().update(workSpace.getInput());
		break;
	case Identify:
		if(workSpace.isActive()) {System.out.println(workSpace.identify(workSpace.getInput()));}
		break;
	case Test:
		runing=0;
		System.out.print("Nhap So Luong TestData: ");
		testData=sc.nextInt();
		System.out.println(workSpace.test(testData));
		workSpace.getDataBase().loadDatatk(testData);
		pixel=workSpace.getDataBase().getTkpixel();
		t.start();
		break;
	default:
		break;
	}}
}
@Override
public void mouseReleased(MouseEvent arg0) {
	
	
}
@Override
public void mouseDragged(MouseEvent arg0) {
	if(arg0.getX()<myFrame.getMyView().getCol()*myFrame.getMyView().getsize()&&arg0.getX()>0&&arg0.getY()<myFrame.getMyView().getRow()*myFrame.getMyView().getsize()&&arg0.getY()>0) {
	workSpace.updateActivation(arg0.getX(),arg0.getY(),myFrame.getMyView().getCol(),myFrame.getMyView().getsize());
	myFrame.getMyView().update(workSpace.getInput());
	workSpace.setActive(true);}
	}
	// TODO Auto-generated method stub
	

@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent arg0) {
	if(arg0.getKeyCode()==arg0.VK_ESCAPE) {System.exit(0);}
	
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
int i;
@Override
public void actionPerformed(ActionEvent e) {
	myFrame.getMyView().update(pixel[runing]);
	System.out.println(workSpace.identify(pixel[runing]));
	runing++;if(runing==testData) {t.stop();}
	// TODO Auto-generated method stub
	
}

}
