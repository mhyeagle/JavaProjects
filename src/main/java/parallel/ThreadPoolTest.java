package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        List<String> list = new ArrayList<>();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            
        }
    }
}
