package MVC;

public class TestMVC {
	public static void main(String[] args) {
		Model m = new CalculateModel();
		CalculateFrame screen = new CalculateFrame();
		Controller c =new CalculateController(m, screen);
		
	}
}
