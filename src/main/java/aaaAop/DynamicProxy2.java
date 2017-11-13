package aaaAop;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy2 implements InvocationHandler
{

	private static Integer client = 1;
    
    //    构造方法，给我们要代理的真实对象赋初值
    
    public DynamicProxy2(){
    	
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
       
        Object result =  client;
        
        //　　在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after 调用");
        System.out.println("打印出结果来："+result);
        return null;
    }

}