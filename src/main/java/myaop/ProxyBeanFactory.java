package myaop;

import java.util.List;

/**
 * 单例的ProxyBeanFactory
 * @author Administrator
 *
 */
public class ProxyBeanFactory {
    private ProxyBeanFactory(){}
    
    private static ProxyBeanFactory beanFactory=null;
    
    public synchronized static ProxyBeanFactory getBeanFactory(){
        if (beanFactory==null) {
            beanFactory=new ProxyBeanFactory();
        }
        return beanFactory;
    }
    
    /**
     * 
     * @param targetClazz 创建指定类target实例
     * @param chain 系统的拦截器链
     * @return
     */
    public Object createProxy(Class<?> targetClazz,List<AbstractMethodInterceptor> chain) throws NotFoundInterfaceException{
        Object proxyBean=null;
        if(targetClazz.getInterfaces().length==0){
            throw new NotFoundInterfaceException(targetClazz);
        }
        try {
            Object target=targetClazz.newInstance();
            proxyBean=new DefaultProxy(target, chain).getProxy();
    
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return proxyBean;
    }
    
    public Object createProxy(Object target,List<AbstractMethodInterceptor> chain) throws NotFoundInterfaceException{
        Object proxyBean=null;
        if(target.getClass().getInterfaces().length==0){
            throw new NotFoundInterfaceException(target.getClass());
        }
        proxyBean=new DefaultProxy(target, chain).getProxy();
        return proxyBean;
    }
}