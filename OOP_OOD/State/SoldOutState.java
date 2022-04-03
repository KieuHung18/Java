package State;

public class SoldOutState implements State{
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("Realease gumball in process");
	}

	@Override
	public void ejectCoin() {
		System.out.println("Eject coin");
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}

	@Override
	public void pullLever() {
		System.out.println("Realease gumball in process");
	}

	@Override
	public void releaseGumball() {
		System.out.println("No Gumball");
	}

}
