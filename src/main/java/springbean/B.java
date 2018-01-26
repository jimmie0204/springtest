package springbean;

import org.springframework.stereotype.Component;

@Component
public class B {

	protected A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public void print(){
		System.out.println("hello~");
	}
}
