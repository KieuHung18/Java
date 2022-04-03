package Template;

import java.util.Scanner;

public class Tea extends BeverageRecipe{

	@Override
	public void brew() {
		recipe+="Steeping tea\n";
	}
	@Override
	public void addCondiment() {
		System.out.println("Add sugar: yes or no");
		if(new Scanner(System.in).nextLine().toLowerCase().equals("yes")) {
			recipe+="Add sugar";
		}
	}
}
