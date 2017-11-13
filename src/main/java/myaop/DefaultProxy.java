package myaop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;


public class DefaultProxy implements InvocationHandler{
    Object target;
    List<AbstractMethodInterceptor> interceptorChain=new ArrayList<AbstractMethodInterceptor>();
    
    public DefaultProxy(Object target, List<AbstractMethodInterceptor> interceptorChain){
        this.target=target;
        if(interceptorChain!=null && interceptorChain.size()>0){
            this.interceptorChain.addAll(interceptorChain);
        }
    }
    
    public final Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        DefaultMethodInvocation methodInvocation=new DefaultMethodInvocation(this, method, target, args, interceptorChain);
        return methodInvocation.proceed();
    }
    
    public Object getProxy(){
        Object proxy=null;
        try {
            proxy=Proxy.newProxyInstance(DefaultProxy.class.getClassLoader(), target.getClass().getInterfaces(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxy;
    }
    
    public Object getTarget(){
        return target;
    }
    
}
