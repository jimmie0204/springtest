package test;

import org.apache.commons.lang.time.StopWatch;

public class ClockTest {
	

	public static void main(String[] args) {
		 StopWatch clock = new StopWatch();
		 clock.start();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 clock.stop();
	}
}
