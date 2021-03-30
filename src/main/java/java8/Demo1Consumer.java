package java8;

import java.util.function.Consumer;

public class Demo1Consumer {
    public static void main(String[] args) {
        consumerString(s -> System.out.println(s));
    }

    private static void consumerString(Consumer<String> function) {
        function.accept("hello");
    }
}
