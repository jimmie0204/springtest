package cglibAopProgress;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<?> clazz) {
		// 设置需要创建子类的类
		 Callback[] callbacks =  
		          new Callback[] { this,  NoOp.INSTANCE };
		enhancer.setSuperclass(clazz);
//		enhancer.setCallback(this);
		enhancer.setCallbacks(callbacks);
		enhancer.setCallbackFilter(new CglibCallBackFilter());
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	// 实现MethodInterceptor接口(public interface MethodInterceptor extends Callback)方法
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("前置代理");
		// 通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("后置代理");
		return result;
	}
	
	
}