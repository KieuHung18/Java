package Adapter;

public class DuckAdapter implements DogLike{
	private DuckLike duck;
	
	public DuckAdapter(DuckLike duck) {
		this.duck = duck;
	}

	@Override
	public void bark() {
		duck.quack();
	}
	
}
