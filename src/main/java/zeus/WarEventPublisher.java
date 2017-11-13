package zeus;

import java.util.ArrayList;
import java.util.List;

import util.ClassUtil;

public class WarEventPublisher {

	public void pushEvent(WarEvent event) throws Exception{
		System.out.println("推送战争事件");
		List<WarEventListener<WarEvent>> list = getAllWarEventListener("zeus");
		for(WarEventListener<WarEvent> temo : list){
			temo.handle(event);
		}
	}
	
	@SuppressWarnings("unused")
	private List<WarEventListener<WarEvent>> getAllWarEventListener(String packageName) throws Exception{
		List<WarEventListener<WarEvent>> list = new ArrayList<WarEventListener<WarEvent>>();
		List<Class> clazzs = ClassUtil.getClasssFromPackage(packageName);
		
		
		for (Class clazz : clazzs) {
			System.out.println(clazz.getName());
		}
		
		list.add(new DruidListener());

		for (WarEventListener<WarEvent> clazz : list) {
			System.out.println(clazz.getClass().getName());
		}
		
		return list;


	}
}
