package controler;


import javax.swing.SwingUtilities;

import object.DataBase;



public class RunProgram {
public static void main(String[] args) {
//	new DataBase().reset();
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			new Controler();
			// TODO Auto-generated method stub
			
		}
	});
}
}
