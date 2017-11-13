package zeus;

public class DruidListener implements WarEventListener<WarEvent> {

	@Override
	public void handle(WarEvent event) {
		System.out.println("DruidListener 处理事件");
		
	}

}
