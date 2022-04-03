package Stratergy;

public abstract class Duck {
	protected Quackable quackable;
	protected Swimable swimable;
	protected Flyable flyable;
	
	public void quack() {
		quackable.quack();
	};
	
	public void fly() {
		flyable.fly();
	};
	
	public void swim() {
		swimable.swim();
	};
	
	public void display() {
		System.out.print("i'm ");
	}
	
	void setQuackable(Quackable q) {
		this.quackable = q;
	}
	
	void setSwimable(Swimable s) {
		this.swimable = s;
	}
	
	void setFlyable(Flyable f) {
		this.flyable = f;
	};
	
}
