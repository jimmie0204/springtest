package cglibAopProgress;

public class TestCglib {

	/**cglib方式生成代理类
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SayHello helloProxy = (SayHello)new CglibProxy().getProxy(SayHello.class);
		helloProxy.say();
		helloProxy.fuck();
	}

}
