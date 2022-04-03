package MVC;

import javax.swing.JOptionPane;
public class CalculateController implements Controller{
	private Model model;
	private CalculateFrame view ;
	public CalculateController(Model model, CalculateFrame view) {
		this.model = model;
		this.view = view;
		view.getOv().setController(this);
		view.getOcv().setController(this);
		view.getOv().setModel(model);
		
	}

	@Override
	public void calculate(String first, String sec, String opr) {
		double f=0,s=0;
		if(first==null||first.equals("")||sec==null||sec.equals("")){
			JOptionPane.showMessageDialog(view, "Empty input");
		}else{
		try {
			f=Double.parseDouble(first);s=Double.parseDouble(sec);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "invalid input");
		}
		}
		if(opr.equals("Add")) {
			model.add(f, s);
			model.setChange();
		}
		if(opr.equals("Multiply")) {
			model.multiply(f, s);
			model.setChange();
		}
		if(opr.equals("Divide")) {
			model.divide(f, s);
			model.setChange();
		}
		
		if(opr.equals("Subtract")) {
			model.subtract(f, s);
			model.setChange();
		}
		
	}

	@Override
	public void changeView(int view) {
		this.view.changeView(view);
	}
	
	@Override
	public void changeOperation(String operation) {
		view.getOv().getOperationLabel().setText(operation);
	}
	
}
