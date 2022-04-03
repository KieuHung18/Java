package State;

public class GumballMachine {
	private State noCoinState;
	private State hasCoinState;
	private State sold;
	private State soldOut;
	
	private State state;
	private int quantity;
	public GumballMachine(int quantity) {
		noCoinState = new NoCoinState(this);
		hasCoinState = new HasCoinState(this);
		sold = new SoldState(this);
		soldOut = new SoldOutState(this);
		state = noCoinState;
		this.quantity=quantity;
	}
	public void insertCoin() {
		state.insertCoin();
	}
	
	public void ejectCoin() {
		state.ejectCoin();
	}
	
	public void pullLever() {
		state.pullLever();
	}
	
	public void releaseGumball() {
		state.releaseGumball();
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void restock(int quantity) {
		ejectCoin();
		this.quantity+=quantity;
	}
	public State getNoCoinState() {
		return noCoinState;
	}
	public State getHasCoinState() {
		return hasCoinState;
	}
	public State getSold() {
		return sold;
	}
	public State getSoldOut() {
		return soldOut;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
