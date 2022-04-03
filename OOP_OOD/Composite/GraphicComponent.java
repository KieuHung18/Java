package Composite;

public abstract class GraphicComponent {
	public abstract void drawing();
	public void add(GraphicComponent graphicComponent) {}
	public void remove(GraphicComponent graphicComponent) {}
	public GraphicComponent getchild(int index) {
		return null;
	}
}
