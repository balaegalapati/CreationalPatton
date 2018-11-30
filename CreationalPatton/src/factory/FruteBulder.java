package factory;

public class FruteBulder {
	private FruteBulder() {
		
	}
	public static Frute getFrute(String type) {
		Frute frute=null;
		
		if("A".equals(type)) {
			frute= new Apple();
			frute.setName();
		}else if("B".equals(type)) {
			frute= new ButterFrute();
			frute.setName();
		}
		return frute;
	}

}
