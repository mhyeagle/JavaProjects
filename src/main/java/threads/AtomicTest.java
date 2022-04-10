package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.get());
        atomicInteger.set(0);
        System.out.println(atomicInteger.get());
        atomicInteger.set(10);
        System.out.println(atomicInteger.get());

        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        threadLocal.set(10L);
        threadLocal.get();
    }
}
