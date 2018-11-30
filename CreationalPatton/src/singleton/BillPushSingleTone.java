package singleton;

public class BillPushSingleTone {
	private BillPushSingleTone() {
		System.out.println(">>"+hashCode());
	}
	
	private static class SingleToneHelper {
		private static BillPushSingleTone instance=new BillPushSingleTone();
	}
	public static BillPushSingleTone getInstance() {
		return SingleToneHelper.instance;
	}

	public static void main(String[] args) {
			Runnable th1=()->{
				BillPushSingleTone ts=BillPushSingleTone.getInstance();
				System.out.println(">Test1>"+ts.hashCode());
			};
			Runnable th2=()->{
				BillPushSingleTone ts=BillPushSingleTone.getInstance();
				System.out.println(">Test2>"+ts.hashCode());
			};
			Runnable th3=()->{
				BillPushSingleTone ts=BillPushSingleTone.getInstance();
				System.out.println(">Test3>"+ts.hashCode());
			};
			for (int i = 0; i < 100; i++) {
				new Thread(th1).start(); 
				new Thread(th2).start(); 
				new Thread(th3).start(); 
			}
			

	
	}

}
