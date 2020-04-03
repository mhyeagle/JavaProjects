package threads;

import java.util.concurrent.Callable;

public class Test1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("in thread" + Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        System.out.println("in main" + Thread.currentThread());

    }
}
