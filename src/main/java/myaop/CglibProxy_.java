package myaop;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy_ implements MethodInterceptor{
	Object target;
	List<AbstractMethodInterceptor> interceptorChain ;
	public CglibProxy_(){
		
	}
	public CglibProxy_(List<AbstractMethodInterceptor> interceptorChain){
        if(interceptorChain!=null && interceptorChain.size()>0){
//            this.interceptorChain.addAll(interceptorChain);
        	this.interceptorChain = interceptorChain;
        }
    }
		
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public List<AbstractMethodInterceptor> getInterceptorChain() {
		return interceptorChain;
	}

	public void setInterceptorChain(List<AbstractMethodInterceptor> interceptorChain) {
		this.interceptorChain = interceptorChain;
	}
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<?> clazz) {
		// 设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		DefaultMethodInvocation4Cglib methodInvocation=new DefaultMethodInvocation4Cglib(method, obj, args, proxy, interceptorChain);
	        return methodInvocation.proceed();
	}
}
