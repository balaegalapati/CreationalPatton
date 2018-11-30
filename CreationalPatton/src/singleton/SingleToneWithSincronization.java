package singleton;

public class SingleToneWithSincronization {
	private static SingleToneWithSincronization instance=null;
	private SingleToneWithSincronization() {
		System.out.println(">>"+hashCode());
	}
	public static SingleToneWithSincronization getInstance() {
		if(instance==null) {
			synchronized (SingleToneWithSincronization.class) {
				if(instance==null) {
					instance=new SingleToneWithSincronization();
					
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Runnable th1=()->{
			SingleToneWithSincronization ts=SingleToneWithSincronization.getInstance();
			System.out.println(">Test1>"+ts.hashCode());
		};
		Runnable th2=()->{
			SingleToneWithSincronization ts=SingleToneWithSincronization.getInstance();
			System.out.println(">Test2>"+ts.hashCode());
		};
		Runnable th3=()->{
			SingleToneWithSincronization ts=SingleToneWithSincronization.getInstance();
			System.out.println(">Test3>"+ts.hashCode());
		};
		for (int i = 0; i < 100; i++) {
			new Thread(th1).start(); 
			new Thread(th2).start(); 
			new Thread(th3).start(); 
		}
		

	}

}
