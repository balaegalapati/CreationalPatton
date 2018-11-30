package factory;

public abstract class Frute {
	protected String name;
	abstract void setName();
	public void displayMyName() {
		System.out.println("My Name is:"+name);
	}

}
