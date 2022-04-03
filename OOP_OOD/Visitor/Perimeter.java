package Visitor;

public class Perimeter implements Visitor{

	@Override
	public int vistorRectengle(Rectengle rect) {
		// TODO Auto-generated method stub
		return (rect.getHeight()+rect.getWidth())*2;
	}

	@Override
	public int vistorSquare(Square sqr) {
		// TODO Auto-generated method stub
		return sqr.getSize()*4;
	}

}
