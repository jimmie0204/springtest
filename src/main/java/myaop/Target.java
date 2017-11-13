package myaop;

/**
 * Target可以是Service层，也可以是DAO层
 * @author fjn
 */
public class Target implements TargetInterface{
    
    public void helloAop(String str) {
        System.out.println("hello, "+str+ ", welcome you use aop in your application");
    }
    
    public void noUseAop(String str){
        System.out.println("hello, "+str+ ", the method has't use AOP .");
    }
}