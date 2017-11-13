package cglib.reflect;


import java.lang.reflect.InvocationTargetException;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import processor.School;

public class CglibReflectTest{
	
	public static void main(String[] args) {
		School sc = new School("papa");
		
		FastClass serviceFastClass = FastClass.create(School.class);
		FastMethod serviceFastMethod = serviceFastClass.getMethod("getAddress", null);


		try {
			Object result = serviceFastMethod.invoke(sc, null);
			System.out.println(result);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}