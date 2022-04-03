package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OperationChooserView extends JPanel implements ActionListener{
	private Controller controller;
	private JButton addOprButton;
	private JButton multiplyOprButton;
	private JButton divideOprButton;
	private JButton subtractOprButton;
	
	public void createView() {
		addOprButton=new JButton("Add");
		multiplyOprButton=new JButton("Multiply");
		divideOprButton=new JButton("Divide");
		subtractOprButton=new JButton("Subtract");
		
		addOprButton.addActionListener(this);
		multiplyOprButton.addActionListener(this);
		divideOprButton.addActionListener(this);
		subtractOprButton.addActionListener(this);
		
		add(addOprButton);
		add(multiplyOprButton);
		add(divideOprButton);
		add(subtractOprButton);
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.changeOperation(e.getActionCommand());
		controller.changeView(CalculateFrame.OPERATION_VIEW);
	}
	
}
