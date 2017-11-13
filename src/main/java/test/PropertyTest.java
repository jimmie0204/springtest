package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyTest {

	private int tt;
	public void setNum(int num){
		setTt(num);
	}
	
	public int getTt() {
		return tt;
	}
	public void setTt(int tt) {
		this.tt = tt;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("test/aa.xml");
		System.out.println(((PropertyTest)act.getBean("numm")).getTt());
	}
}
