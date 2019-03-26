package springDemoBean;

public class Bean01 {
     private int age;
     private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bean01(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Bean01() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void say() {
		System.out.println("Bean01 [age=" + age + ", name=" + name + "]");
	}
     public void strat() {
    	System.out.println("startmethod"); 
     }
     public void stop() {
    	 System.out.println("stopmethod"); 
     }
}
