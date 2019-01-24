import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuavaAsync {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(executor);

        ListenableFuture<String> lf = listeningExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("task started!");
                Thread.sleep(3000);
                System.out.println("task finished!");

                return "hello";
            }
        });

        Futures.addCallback(lf, new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("success " + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("failure");
            }
        });

        System.out.println("main thread exit");
    }
}
