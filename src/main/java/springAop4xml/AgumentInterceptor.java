package springAop4xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgumentInterceptor implements MethodInterceptor {
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String name = null;
		Object[] args = methodInvocation.getArguments();
		name = methodInvocation.getMethod().getName();
		System.out.println("输出args[i]，长度为："+args.length);
		for (int i = 0; i < args.length; i++) {
			/*if (args[i] instanceof String) {
				name = (String) args[i];
			}*/
			System.out.println(args[i]);
			
		}
		System.out.println("the method is : " + name);
		Object result = methodInvocation.proceed();
		System.out.println("the result is :"+result);
		return result;
	}
}