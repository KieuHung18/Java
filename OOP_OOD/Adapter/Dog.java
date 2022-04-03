package Adapter;

public abstract class Dog implements DogLike{
	protected Barkable barkable;
	@Override
	public void bark() {
		barkable.bark();
	}

}
