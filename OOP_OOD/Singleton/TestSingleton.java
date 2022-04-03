package Singleton;

public class TestSingleton extends Thread{
	private String name;
	public TestSingleton(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		TestSingleton thread1 =new TestSingleton("Thread 1");
		TestSingleton thread2 =new TestSingleton("Thread 2");
		thread1.start();thread2.start();
	}
	
	@Override
	public void run() {
		//choose class to test singleton
//		EagerTimer();
		LazyTimer();
	}
	
	public void EagerTimer() {
		EagerLoading eagerLoading = EagerLoading.getIntance();
		eagerLoading.startTimer(name);
	}
	
	public void LazyTimer() {
		LazyLoading eagerLoading = LazyLoading.getIntance();
		eagerLoading.startTimer(name);
	}
}
