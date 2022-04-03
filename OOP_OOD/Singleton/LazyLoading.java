package Singleton;

public class LazyLoading {
	private int timer;
	private volatile static LazyLoading intance;
	private LazyLoading() {
		
	}
	
	public static LazyLoading getIntance() {
		if(intance==null) {
			synchronized (LazyLoading.class) {
				if(intance==null) {
					return intance=new LazyLoading();
				}else {
					return intance;
				}
			}
		}
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
