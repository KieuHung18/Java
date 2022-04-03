package State;

public class TestState {
public static void main(String[] args) {
	GumballMachine gumballMachine = new GumballMachine(1);
	gumballMachine.insertCoin();
	gumballMachine.pullLever();
	gumballMachine.ejectCoin();
	gumballMachine.releaseGumball();
	System.out.println();
	gumballMachine.insertCoin();
	gumballMachine.pullLever();
	gumballMachine.ejectCoin();
	gumballMachine.releaseGumball();
	gumballMachine.restock(10);
	gumballMachine.insertCoin();
	gumballMachine.pullLever();
	gumballMachine.releaseGumball();
}
}
