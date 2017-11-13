package aaaAop;

public class RealSubject implements Subject, Swim
{
    public void rent()
    {
        System.out.println("I want to rent my house");
    }
    
    
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }

	public void swim() {
		System.out.println("i can swim");
		
	}
}