package sourceCode;

import java.util.concurrent.locks.LockSupport;

public class TestPark {
    public static void main(String[] args) {
        Thread boyThread = new Thread(() -> {
            try {
                Thread.sleep(4000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("boy: up now");
            LockSupport.park();
            System.out.println("boy: park1");
            LockSupport.park();
            System.out.println("boy: park2");
            System.out.println("boy: done");
        });

        Thread girlThread = new Thread(() -> {

            System.out.println("girl: permit");
            LockSupport.unpark(boyThread);
            try {
                Thread.sleep(8000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LockSupport.unpark(boyThread);
        });

        boyThread.start();
        girlThread.start();
    }
}
