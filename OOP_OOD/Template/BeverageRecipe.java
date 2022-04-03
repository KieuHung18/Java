package Template;

public abstract class BeverageRecipe {
	protected String recipe="";
	public String getRecipe() {
		boiledWater();
		brew();
		pourInCup();
		addCondiment();
		return recipe;
	}
	
	public void boiledWater(){
		recipe+="Boiled water\n";
	}
	
	public abstract void brew();
	
	public void pourInCup() {
		recipe+="Pour in cup\n";
	}
	
	public void addCondiment() {}
}
