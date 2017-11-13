package springAop4xml;

public class CommonEmployee{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void signIn(String name,String fdg) {
		System.out.println(name + "已经签到了...........");
	}
}
