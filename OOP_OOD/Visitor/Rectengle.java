package Visitor;

public class Rectengle implements Visitable{
	private int width,
				height;

	public Rectengle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int accept(Visitor visitor) {
		return visitor.vistorRectengle(this);
	}
	
}
