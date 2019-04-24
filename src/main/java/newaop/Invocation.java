package newaop;

import java.util.List;

/**
 * @author jimmie
 * @create 2019-04-24 下午5:46
 */
public interface Invocation {

    Object proceed();

    public static class MethodInvocation implements Invocation{
        private List<MethodInterceptor> list;
        private int index=-1;
        private int ListSize=0;
        public MethodInvocation(List<MethodInterceptor> list) {
            this.list=list;
            ListSize=list.size();
        }

        @Override
        public Object proceed() {//控制逻辑，递归调用
            if(index==ListSize-1){
                System.out.println("执行方法实体");
                return "返回值";
            }
            MethodInterceptor methodInterceptor = list.get(++index);
            return  methodInterceptor.invoke(this);
        }
    }
}
