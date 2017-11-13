package aaaAop;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class TestMain {

	public static void main(String[] args) {
		
		Subject s = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new DynamicProxy(new Zeus()));

		s.rent();
		createProxyClassFile();  
	}
	
	public static void createProxyClassFile()   
	  {   
	    String name = "ProxySubject";   
	    byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );   
	    try  
	    {   
	      FileOutputStream out = new FileOutputStream( name + ".class" );   
	      out.write( data );   
	      out.close();   
	      System.out.println("xie   success");
	    }   
	    catch( Exception e )   
	    {   
	      e.printStackTrace();   
	    }   
	  }   

}
