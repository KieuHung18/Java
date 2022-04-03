package Visitor;

public class TestVisitor {
	public static void main(String[] args) {
		Rectengle rect =new Rectengle(5, 6);
		Square sqr = new Square(8);
		Area area =new Area();
		Perimeter perimeter = new Perimeter();
		int rectArea=rect.accept(area),
			sqrArea=sqr.accept(area),
			rectPerimeter=rect.accept(perimeter),
			squarePerimeter= sqr.accept(perimeter);
		System.out.println(
				"Rectengle Area: "+rectArea+"\n"+
				"Square Area: "+sqrArea+"\n"+
				"Rectengle Perimeter: "+rectPerimeter+"\n"+
				"Square Perimeter: "+squarePerimeter+"\n");
	}
}
