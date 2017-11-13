package aaaAop;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler
{
    //　这个就是我们要代理的真实对象
    private Object subject;
    
    //    构造方法，给我们要代理的真实对象赋初值
    
    public DynamicProxy(){
    	
    }
    public DynamicProxy(Object subject)
    {
        this.subject = subject;
    }
    
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable
    {
    	System.out.println(object.getClass());
    	System.out.println(object.getClass() instanceof Serializable);
    	
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before 调用");
        
        System.out.println("Method:" + method);
        
        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        //模拟调用远程方法
        String interName = object.getClass().getInterfaces()[0].getName();
       
        Object result =  fuckRPC(subject,interName,method,args);
        
        //　　在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after 调用");
        System.out.println("打印出结果来："+result);
        return null;
    }
	private Object fuckRPC(Object subject,String interName, Method method, Object[] args) {
		System.out.println("代理的接口名字"+interName);
		System.out.println("代理的接口方法"+method.getName());
		System.out.println("代理的接口方法参数"+args);
		((Zeus)subject).war();
		
		System.out.println("正在用RPC查找，已找到，并开始返回结果");
		return true;
	}

}