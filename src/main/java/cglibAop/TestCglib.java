package cglibAop;

import aaaAop.Swim;

public class TestCglib {

	/**cglib方式生成代理类
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SayHello helloProxy = (SayHello)new CglibProxy().getProxy(SayHello.class);
		helloProxy.say();
		SayHello h = new SayHello();
		System.out.println(helloProxy.getClass().getCanonicalName());
		System.out.println(helloProxy.getClass().getName());
		System.out.println(helloProxy.getClass().getSimpleName());



		System.out.println(h.getClass().getCanonicalName());
		System.out.println(h.getClass().getName());
		System.out.println(h.getClass().getSimpleName());
//		Swim swim = (Swim)new CglibProxy().getProxy(Swim.class);
//		swim.swim();
	}

}
