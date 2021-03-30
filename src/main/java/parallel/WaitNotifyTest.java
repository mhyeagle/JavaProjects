package parallel;

import java.util.ArrayDeque;
import java.util.Queue;

public class WaitNotifyTest {
    private Integer limit = 10;
    private Queue<String> queue;

    public WaitNotifyTest() {
        queue = new ArrayDeque<>(limit);
    }

    public synchronized void put(String product) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        queue.add(product);
        System.out.println("put into " + product);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        String product = queue.poll();
        System.out.println("take from queue: " + product);
        notifyAll();
        return product;
    }

    // -------------
    public static void main(String[] args) {
        WaitNotifyTest waitNotifyQueue = new WaitNotifyTest();
        Thread threadProducer = new Thread(new Runnable() {
            @Override
            public void run() {
                int offset = 0;
                while (true) {
                    try {
                        waitNotifyQueue.put("product-" + offset++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadConsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String product = waitNotifyQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadProducer.start();
        threadConsumer.start();
    }
}
