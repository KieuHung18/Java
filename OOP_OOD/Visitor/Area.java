package Visitor;

public class Area implements Visitor{

	@Override
	public int vistorRectengle(Rectengle rect) {
		// TODO Auto-generated method stub
		return rect.getWidth()*rect.getHeight();
	}

	@Override
	public int vistorSquare(Square sqr) {
		// TODO Auto-generated method stub
		return sqr.getSize()*sqr.getSize();
	}

}
