package springAop4xml;

import java.util.Date;  
import org.aspectj.lang.ProceedingJoinPoint;  
  
public class Logger{  
  
    //spring中Before通知  
    public void logBefore() {  
        System.out.println("logBefore:现在时间是:"+new Date());  
    }  
      
    //spring中After通知  
    public void logAfter() {  
        System.out.println("logAfter:现在时间是:"+new Date());  
    }  
      
    //spring中Around通知  
    public Object logAround(ProceedingJoinPoint joinPoint) {  
        System.out.println("logAround开始:现在时间是:"+new Date()); //方法执行前的代理处理  
        Object[] args = joinPoint.getArgs();  
        Object obj = null;  
        try {  
            obj = joinPoint.proceed(args);  
        } catch (Throwable e) {  
            e.printStackTrace();  
        }  
        System.out.println("logAround结束:现在时间是:"+new Date());  //方法执行后的代理处理  
        return obj;  
    }  
      
} 