package myaop;


import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInvocation;


/**
 * method 与 PointCut 匹配器
 * 支持的方法名表达式有：
 *  1)*xxx, 以*开头
 *  2)xxx*, 以*结尾
 *  3)*    所有
 *  4)没有*,指定方法名
 *  
 * @author fjn
 */
public class AdviceMatcher {
    private AbstractMethodInterceptor interceptor;
    private MethodInvocation invocation;
    AdviceMatcher(AbstractMethodInterceptor interceptor, MethodInvocation invocation){
        this.interceptor=interceptor;
        this.invocation=invocation;
    }
    
    
    public boolean match(Class<?> adviceAnnotationType, String joinPoint){
        // 要执行的方法
        String methodName=invocation.getMethod().getName();
        try {
            Method adviceMethod=interceptor.getClass().getDeclaredMethod(joinPoint, new Class[]{});
            if(adviceAnnotationType==Before.class){
                Before before=adviceMethod.getAnnotation(Before.class);
                if(before==null) return false;
                String pointcut=before.expression();
                return beforeOrAfterMatch(pointcut, methodName);
            }else
            if(adviceAnnotationType==After.class){
                After after=adviceMethod.getAnnotation(After.class);
                if(after==null) return false;
                String pointcut=after.expression();
                return beforeOrAfterMatch(pointcut, methodName);
            }
            
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 支持的方法名表达式有：
     *  1)*xxx, 以*开头
     *  2)xxx*, 以*结尾
     *  3)*    所有
     *  4)没有*,指定方法名
     *  
     * @param pointcut
     * @param methodName
     * @return
     */
    private boolean beforeOrAfterMatch(String pointcut, String methodName){
        int indexOfStar=pointcut.indexOf("*");
        if(indexOfStar!=-1){// 方法名中有*号
            if(indexOfStar==0){// 以*开头
                if("*".equals(pointcut)){// 只有*
                    return true;
                }
                else{
                    return methodName.endsWith(pointcut.substring(1));
                }
            }else {// 以*结尾，中间有*也算以*结尾
                return methodName.startsWith(pointcut.substring(0, indexOfStar));
            }
        }else{
            return methodName.equals(pointcut);
        }
    }
}