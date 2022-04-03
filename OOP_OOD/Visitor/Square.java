package Visitor;

public class Square implements Visitable{
	private int size;

	public Square(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	@Override
	public int accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.vistorSquare(this);
	}

	
}
