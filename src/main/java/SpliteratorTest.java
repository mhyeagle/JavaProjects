import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class SpliteratorTest {
    AtomicInteger count = new AtomicInteger(0);
    List<String> list = createList();
    Spliterator spliterator = list.spliterator();

    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++) {
//            new MyThread().start();
//        }
        SpliteratorTest test = new SpliteratorTest();
        test.myTest();

    }

    public void myTest() {
        for (int i = 0; i < 4; i++) {
            new MyThread().start();
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结果为:" + count);
    }

    private List<String> createList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                result.add(i + "");
            } else {
                result.add("aaa");
            }
        }

        return result;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("线程" + threadName + "开始运行------");
            spliterator.trySplit().forEachRemaining(new Consumer() {
                @Override
                public void accept(Object o) {
                    if (isInteger((String)o)) {
                        int num = Integer.parseInt(o + "");
                        count.addAndGet(num);
                        System.out.println("数值: " + num + "------" + threadName);

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            System.out.println("线程" + threadName + "运行结束------");
        }
    }
}
