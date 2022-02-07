package parallel;

public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " get resource1");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resource2");
                }
            }
        }, "线程一").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + " get resource2");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + " get resource1");
                }
            }
        }).start();
    }
}
