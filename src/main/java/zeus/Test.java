package zeus;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WarEvent ll = new WarEvent(new Object());
		new WarEventPublisher().pushEvent(ll);
		
	}

}
