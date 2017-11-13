package interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("Log start...");
		Object result = null;
		result = methodInvocation.proceed();
		System.out.println("Log end...");
		return result;
	}
}