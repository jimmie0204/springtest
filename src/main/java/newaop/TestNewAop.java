package newaop;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author jimmie
 * @create 2019-04-24 下午5:48
 */
public class TestNewAop {

    public static void main(String[] args){
        List<MethodInterceptor> list = Lists.newArrayList();
        list.add(new MethodInterceptor.AfterMethodInterceptor());
        list.add(new MethodInterceptor.BeforeMethodInterceptor("hello"));
        list.add(new MethodInterceptor.BeforeMethodInterceptor("fuck"));
        list.add(new MethodInterceptor.AfterRuturningMethodInterceptor());
        Invocation invocation = new Invocation.MethodInvocation(list);

        invocation.proceed();
    }
}
