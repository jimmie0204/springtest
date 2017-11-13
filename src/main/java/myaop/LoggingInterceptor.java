package myaop;


public class LoggingInterceptor extends AbstractMethodInterceptor{

    @Before(expression="hello*")
    public void beforeAdvice(){
        System.out.println("Logging: before advice invoked ...");
    }

    @After(expression="*Aop")
    public void afterAdvice(){
        System.out.println("Logging: after advice invoked ...");
    }
    

}