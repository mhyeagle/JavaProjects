package threads;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) throws NoSuchFieldException {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.get());
        atomicInteger.set(0);
        System.out.println(atomicInteger.get());
        atomicInteger.set(10);
        System.out.println(atomicInteger.get());

        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        threadLocal.set(100L);
        System.out.println(threadLocal.get());

        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set("this is a test thread local");
        System.out.println(threadLocal1.get());

        Class<?> clazz = Thread.class;
        Field[] fields = clazz.getFields();
        Field fields1 = clazz.getField("daemon");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
        }
    }
}
