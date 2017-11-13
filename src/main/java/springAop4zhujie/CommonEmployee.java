package springAop4zhujie;

import org.springframework.stereotype.Service;

@Service(value="employee")
public class CommonEmployee implements Employee{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String signIn(String name) {
		System.out.println(name + "已经签到了...........");
		return name;
	}
	
	public void throwTest() throws Exception{
		try {
			int i=1/0;
		} catch (Exception e) {
			throw new Exception("除数不能为0");
		}
		
	}

}
