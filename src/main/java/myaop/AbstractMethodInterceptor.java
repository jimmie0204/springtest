package myaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public abstract class AbstractMethodInterceptor implements MethodInterceptor{

    public final Object invoke(MethodInvocation invocation) throws Throwable {
//        Object result=invocation.proceed();
//        return result;
    	System.out.println("我就是打酱油的，一点用木有");
    	return null;
    }
    
    
    public abstract void beforeAdvice();
    
    public abstract void afterAdvice();
    
}