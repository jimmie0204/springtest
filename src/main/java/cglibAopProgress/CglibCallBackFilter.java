package cglibAopProgress;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class CglibCallBackFilter implements CallbackFilter{

	@Override
	public int accept(Method paramMethod) {
		if(paramMethod.getName().equalsIgnoreCase("fuck"))
			return 1;//不代理，直接返回父类方法实现（返回的是callbacks数组的下标）
		return 0;
	}

}
