package MVC;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculateFrame extends JFrame{
	public static final int OPERATION_CHOOSER_VIEW=0;
	public static final int OPERATION_VIEW=1;
	private OperationView ov ;
	private OperationChooserView ocv;
	public CalculateFrame() {
		ov=new OperationView();
		ocv=new OperationChooserView();
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		ocv.createView();
		ov.createView();
		add(ocv);
		revalidate();
	}
	public void changeView(int View) {
		switch (View) {
		case OPERATION_CHOOSER_VIEW:
			remove(ov);
			add(ocv);
			repaint();
			revalidate();
			break;
		case OPERATION_VIEW:
			remove(ocv);
			add(ov);
			repaint();
			revalidate();
			break;
		default:
			break;
		}
	}
	public OperationView getOv() {
		return ov;
	}
	public OperationChooserView getOcv() {
		return ocv;
	}
	
}
