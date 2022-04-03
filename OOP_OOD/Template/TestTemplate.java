package Template;

public class TestTemplate {
	public static void main(String[] args) {
		System.out.println("TEA");
		BeverageRecipe teaRecipe =new Tea();
		
		System.out.println(teaRecipe.getRecipe());
		System.out.println("COFFEE");
		BeverageRecipe coffRecipe =new Coffee();
		System.out.println(coffRecipe.getRecipe());
	}
}
