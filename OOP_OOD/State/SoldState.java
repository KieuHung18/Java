package State;

public class SoldState implements State{
	private GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("Realease gumball in process");
	}

	@Override
	public void ejectCoin() {
		System.out.println("Realease gumball in process");
	}

	@Override
	public void pullLever() {
		System.out.println("Realease gumball in process");
	}

	@Override
	public void releaseGumball() {
		if(gumballMachine.getQuantity()==0) {
			gumballMachine.setState(gumballMachine.getSoldOut());
			System.out.println("No gumball");
		}
		else {
			gumballMachine.setState(gumballMachine.getNoCoinState());
			gumballMachine.setQuantity(gumballMachine.getQuantity()-1);
			System.out.println("Realease gumball");
		}
		
	}

}
