package springDemoBean;

public class ExampleBean {
       private int i;
       private YetAnorherBean yetbean;
       private AnotherBean anotherbean;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public YetAnorherBean getYetbean() {
		return yetbean;
	}
	public void setYetbean(YetAnorherBean yetbean) {
		this.yetbean = yetbean;
	}
	public AnotherBean getAnotherbean() {
		return anotherbean;
	}
	public void setAnotherbean(AnotherBean anotherbean) {
		this.anotherbean = anotherbean;
	}
	public ExampleBean(int i, YetAnorherBean yetbean, AnotherBean anotherbean) {
		super();
		this.i = i;
		this.yetbean = yetbean;
		this.anotherbean = anotherbean;
	}
	public ExampleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void say() {
		System.out.println("ExampleBean [i=" + i + ", yetbean=" + yetbean.getYetName() + ", anotherbean=" + anotherbean.getAnotherName() + "]");
	}
	
}
