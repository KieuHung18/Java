package Composite;

import java.util.ArrayList;

public class MyGraphic extends GraphicComponent{
	private ArrayList<GraphicComponent> componentList;
	
	public MyGraphic() {
		this.componentList = new ArrayList<>();
	}
	
	@Override
	public void add(GraphicComponent graphicComponent) {
		componentList.add(graphicComponent);
	}
	
	@Override
	public void remove(GraphicComponent graphicComponent) {
		componentList.remove(graphicComponent);
	}
	
	@Override
	public GraphicComponent getchild(int index) {
		return componentList.get(index);
	}

	@Override
	public void drawing() {
		for(int i=0;i<componentList.size();i++) {
			componentList.get(i).drawing();
		}
	}
}
