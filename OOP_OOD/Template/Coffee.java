package Template;

import java.util.Scanner;

public class Coffee extends BeverageRecipe{

	@Override
	public void brew() {	
		recipe+="Dripping coffe\n";
	}
	@Override
	public void addCondiment() {
		System.out.println("Add milk: yes or no");
		if(new Scanner(System.in).nextLine().toLowerCase().equals("yes")) {
			recipe+="Add milk";
		}
	}
}
