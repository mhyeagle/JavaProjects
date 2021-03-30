package parallel;

public class SynchronizedTest {
    private Integer counter = 0;

    public synchronized Integer getCounter() {
        return counter;
    }

    public synchronized void incrCounter() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest num = new SynchronizedTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    num.incrCounter();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    num.incrCounter();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("result count:" + num.getCounter());
    }
}
