package Adapter;

public class Duck implements DuckLike{
	protected Quackable quackable;
	@Override
	public void quack() {
		quackable.quack();
	}

}
