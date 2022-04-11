package parallel;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.eclipse.jetty.util.ConcurrentHashSet;

import java.util.Set;
import java.util.concurrent.*;

/**
 * 从线程向线程池中提交的任务，可以使用提交任务之外的Collection变量，该Collection变量中的内容会被修改
 */
public class CompletableFutureTest {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("TestExecutor-pool-%d").build();
    private static final Executor executor = new ThreadPoolExecutor(20, 200, 0,
            TimeUnit.MINUTES, new LinkedBlockingDeque<>(1024), namedThreadFactory);

    public static void main(String[] args) {
        Set<String> tmpSet = new ConcurrentHashSet<>();
        final String mainStr = "mainStr";

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            Thread thread = Thread.currentThread();
            tmpSet.add(thread.getName());
            System.out.println("" + thread.getName() + ":" + mainStr);
            return "test";
        }, executor);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
