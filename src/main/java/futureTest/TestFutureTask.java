package futureTest;

import java.util.HashMap;
import java.util.concurrent.*;

public class TestFutureTask {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        ExecutorService es1 = Executors.newFixedThreadPool(10);

        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                HashMap<String, String> map = new HashMap<>();
                return "success";
            }
        });

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String result = task.get();
                        System.out.println(Thread.currentThread().getName() + " has complete");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(task).start();
    }
}
