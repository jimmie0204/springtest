package myaop;


public class AnotherInterceptor extends AbstractMethodInterceptor{
    @Override
    @After(expression="*")
    public void afterAdvice() {
        System.out.println("another: after");
    }
    
    @Override
    @Before(expression="*")
    public void beforeAdvice() {
        System.out.println("another: before");
    }
}