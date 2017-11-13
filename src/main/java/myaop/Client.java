package myaop;


import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        // 初始化配置的拦截器链。
        // 这里【相当于】Spring的在XML文件中配置AOP或者在拦截器上指定@AspectJ
        List<AbstractMethodInterceptor> interceptorChain=new ArrayList<AbstractMethodInterceptor>();
        interceptorChain.add(new LoggingInterceptor());
        interceptorChain.add(new AnotherInterceptor());
        
        // 这里相当于Spring的通过IOC创建的代理Bean
        TargetInterface target = null;
		try {
			target = (TargetInterface)ProxyBeanFactory.getBeanFactory().createProxy(Target.class, interceptorChain);
		} catch (NotFoundInterfaceException e) {
			e.printStackTrace();
		}
        
        // 我们在使用Spring时，只需要写下面的代码就可以了：
        target.helloAop("zhang san");
        System.out.println("--------------------------");
        target.noUseAop("zhang san");
        System.out.println("--------------------------");
        target.helloAop("zhang san");
        
    }
}