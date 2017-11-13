package springthread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

 


 


// 指定的运行runner，并且把你所指定的Runner作为参数传递给它

@ContextConfiguration(locations = "classpath*:springthread.xml")

public class TestThreadPool extends AbstractJUnit4SpringContextTests {



  private static int produceTaskSleepTime = 10;



  private static int produceTaskMaxNumber = 1000;



  @Autowired

  private ThreadPoolTaskExecutor threadPoolTaskExecutor;



  public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {

      return threadPoolTaskExecutor;

  }



  public void setThreadPoolTaskExecutor(

          ThreadPoolTaskExecutor threadPoolTaskExecutor) {

      this.threadPoolTaskExecutor = threadPoolTaskExecutor;

  }




  public void testThreadPoolExecutor() {

      for (int i = 1; i <= produceTaskMaxNumber; i++) {

          try {

              Thread.sleep(produceTaskSleepTime);

          } catch (InterruptedException e1) {

              e1.printStackTrace();

          }

          new Thread(new StartTaskThread(threadPoolTaskExecutor, i)).start();

      }



  }

  public static void main(String[] args) {
	new TestThreadPool().testThreadPoolExecutor();
}


}