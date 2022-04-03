package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperationView extends JPanel implements ActionListener,MyObserver{
	private Controller controller;
	private Model model;
	private double result;
	
	private JTextField firstNumber;
	private JLabel operationLabel;
	private JTextField secondNumber;
	private JButton calculateButton;
	private JButton backButton;
	private JLabel calcSolution;

	public void createView() {
		
		firstNumber  = new JTextField(10);
		operationLabel = new JLabel();
		secondNumber = new JTextField(10);
		calculateButton = new JButton("Calculate");
		backButton = new JButton("Back");
		calcSolution = new JLabel("result: "+result);
		
		calculateButton.addActionListener(this);
		backButton.addActionListener(this);
		
		add(firstNumber);
		add(operationLabel);
		add(secondNumber);
		add(calculateButton);
		add(calcSolution);
		add(backButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Calculate")) {
			controller.calculate(firstNumber.getText(),
					secondNumber.getText(),
					operationLabel.getText());
		}
		if(e.getActionCommand().equals("Back")) {
			result=0;
			calcSolution.setText("result: "+result);
			controller.changeView(CalculateFrame.OPERATION_CHOOSER_VIEW);
		}
		
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public void setModel(Model model) {
		this.model = model;
		model.addObserver(this);
	}
	@Override
	public void update() {
		result=model.getResult();
		calcSolution.setText("result: "+result);
		repaint();
	}
	public JLabel getOperationLabel() {
		return operationLabel;
	}
}
