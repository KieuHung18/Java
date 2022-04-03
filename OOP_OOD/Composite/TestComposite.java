package Composite;

public class TestComposite {
	public static void main(String[] args) {
		GraphicComponent line = new Line();
		GraphicComponent rectangle =new Rectangle();
		GraphicComponent triangle =new Triangle();
		GraphicComponent graphic =new MyGraphic();
		GraphicComponent picture =new MyGraphic();
		
		
		graphic.add(rectangle);
		graphic.add(triangle);
		
		picture.add(line);
		picture.add(graphic);
		picture.drawing();
	}
}
