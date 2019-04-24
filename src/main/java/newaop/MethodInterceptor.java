package newaop;

/**
 * @author jimmie  链式迭代
 * @create 2019-04-24 下午5:47
 */
public interface MethodInterceptor {

    Object invoke(Invocation invocation);


    public static class BeforeMethodInterceptor implements MethodInterceptor{
        private String name;
        public BeforeMethodInterceptor(String name) {
            this.name=name;
        }

        @Override
        public Object invoke(Invocation invocation) {
            System.out.println("before method "+name);

            return invocation.proceed();
        }
    }
    public static class AfterRuturningMethodInterceptor implements MethodInterceptor{
        @Override
        public Object invoke(Invocation invocation) {
            Object proceed = invocation.proceed();
            System.out.println("afterRuturning method 1");
            return proceed;
        }
    }
    public static class AfterMethodInterceptor implements MethodInterceptor{
        @Override
        public Object invoke(Invocation invocation) {
            try {
                return invocation.proceed();
            }finally {
                System.out.println("after");
            }

        }
    }
}