package Singleton;

public class EagerLoading {
	private int timer;
	private static EagerLoading intance =new EagerLoading();
	private EagerLoading() {
		
	}
	
	public static EagerLoading getIntance() {
		return intance;
	}
	
	public void startTimer(String owner) {
		while(1<2) {
			System.out.println(owner+": "+timer++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
