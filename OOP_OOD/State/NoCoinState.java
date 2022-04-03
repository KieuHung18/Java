package State;

public class NoCoinState implements State{
	private GumballMachine gumballMachine;
	public NoCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertCoin() {
		gumballMachine.setState(gumballMachine.getHasCoinState());
		System.out.println("Insert coin");
	}

	@Override
	public void ejectCoin() {
		System.out.println("There is no coin");
	}

	@Override
	public void pullLever() {
		System.out.println("Need insert coin");
	}

	@Override
	public void releaseGumball() {
		System.out.println("Need insert coin then pull lever");
	}

}
