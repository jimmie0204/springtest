package interceptor;

public class HelloSpeaker implements IHello {
	public void sayHello(String name) {
		System.out.println("Hello," + name);
	}
}