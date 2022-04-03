package State;

public class HasCoinState implements State{
	private GumballMachine gumballMachine;
	
	public HasCoinState(GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	
	public void insertCoin() {
		System.out.println("Already has coin");
	}

	@Override
	public void ejectCoin() {
		System.out.println("Pull the lever first");
	}

	@Override
	public void pullLever() {
		System.out.println("pull lever");
		gumballMachine.setState(gumballMachine.getSold());
	}

	@Override
	public void releaseGumball() {
		System.out.println("Pull the lever first");
	}

}
