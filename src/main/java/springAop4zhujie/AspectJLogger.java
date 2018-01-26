package springAop4zhujie;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;  

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;  
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
  
/** 
 * 使用@Aspect 注解的类， Spring 将会把它当作一个特殊的Bean（一个切面），也就是 
 * 不对这个类本身进行动态代理 
 */
@Component
@Aspect
@Order(1)
public class AspectJLogger {  
    /** 
     * 必须为final String类型的,注解里要使用的变量只能是静态常量类型的 
     */  
    public static final String EDP = "execution(* springAop4zhujie.CommonEmployee.*(..))";
      
//    @Before(EDP)    //spring中Before通知
    public void logBefore() {  
        System.out.println("logBefore:现在时间是:"+new Date());  
    }  
      
//    @After(EDP)    //spring中After通知
    public void logAfter() {  
        System.out.println("logAfter:现在时间是:"+new Date());  
    }  
      
    @Around(EDP)   //spring中Around通知  
    public Object logAround(ProceedingJoinPoint joinPoint) {
        System.out.println("logAround开始:现在时间是:"+new Date()); //方法执行前的代理处理  
        Object[] args = joinPoint.getArgs(); 
        for(int i=0;i<args.length;i++){
        	System.out.println("第"+i+"个参数是：=="+args[i]);
        }
        Signature  dd = joinPoint.getSignature();
        Method method = MethodSignature.class.cast(joinPoint.getSignature()).getMethod(); 
    	System.out.println("测试logAround的joinPoint方法:===="+MethodSignature.class.cast(dd).getMethod());
    	System.out.println("测试logAround的joinPoint方法名字:===="+MethodSignature.class.cast(dd).getMethod().getName());
 
        Object obj = null;  
        try {  
            obj = joinPoint.proceed(args); 
            System.out.println("请求方法已经执行完，返回值是:"+obj);
        } catch (Throwable e) {  
            e.printStackTrace();  
        }  
        System.out.println("logAround结束:现在时间是:"+new Date());  //方法执行后的代理处理  
        return obj;  
    }
    
//    @AfterReturning(pointcut=EDP,returning="qqobj")//获取方法返回参数必须要加（returning="qqobj"），qqobj为@Around的返回值,名称随意写
    public void logAfterReturn(JoinPoint joinPoint, Object qqobj) {
    	Signature  dd = joinPoint.getSignature();
    	System.out.println("测试AfterReturning的joinPoint方法:===="+MethodSignature.class.cast(dd).getMethod());
    	System.out.println("测试AfterReturning的joinPoint方法名字:===="+MethodSignature.class.cast(dd).getMethod().getName());
    	 /*System.out.println("@AfterReturning：开始...");
         System.out.println("@AfterReturning：目标方法为：" + 
        		 joinPoint.getSignature().getDeclaringTypeName() + 
                 "." + joinPoint.getSignature().getName());
         System.out.println("@AfterReturning：参数为：" + 
                 Arrays.toString(joinPoint.getArgs()));
         System.out.println("@AfterReturning：返回值为：" + qqobj);
         System.out.println("@AfterReturning：被织入的目标对象为：" + joinPoint.getTarget());*/
    }
    
//    @AfterThrowing(pointcut=EDP, throwing="e")
    public void throwtest(JoinPoint joinPoint, Throwable e) throws Exception{
    	Signature  dd = joinPoint.getSignature();
    	System.out.println("测试AfterThrowing的joinPoint方法:===="+MethodSignature.class.cast(dd).getMethod());
    	System.out.println("测试AfterThrowing的joinPoint方法名字:===="+MethodSignature.class.cast(dd).getMethod().getName());
//    	e.printStackTrace();
    }
} 