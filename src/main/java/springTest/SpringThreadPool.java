package springTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class SpringThreadPool {
    private static final Logger logger = LoggerFactory.getLogger(SpringThreadPool.class);

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        MultiTask task = (MultiTask) factory.getBean("multiTask");
        ThreadPoolTaskExecutor threadPool = (ThreadPoolTaskExecutor) factory.getBean("taskExecutor");
        for (int i = 0; i < 20; i++) {
            threadPool.execute(task);
            System.out.println("int i is " + i + ", now threadpool active threads totalnum is " + threadPool.getActiveCount());
            logger.debug("test");
        }
    }
}
