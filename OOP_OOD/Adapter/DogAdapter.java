package Adapter;

public class DogAdapter implements DuckLike{
	DogLike dog;
	
	public DogAdapter(DogLike dog) {
		this.dog = dog;
	}

	@Override
	public void quack() {
		dog.bark();
		// TODO Auto-generated method stub
		
	}

}
