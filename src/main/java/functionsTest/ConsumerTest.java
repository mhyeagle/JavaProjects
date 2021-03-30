package functionsTest;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer c = System.out::println;
        Consumer c2 = n -> System.out.println(n + "-F2");
        Consumer c3 = n -> System.out.println(n + "-F3");

        c.andThen(c2).andThen(c3).accept("test");

        c.andThen(c).andThen(c).andThen(c).accept("test2");

        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;

        System.out.println("f.compose(g).apply(1)");
        System.out.println(f.compose(g).apply(1));
        System.out.println("f.andThen(g).apply(1)");
        System.out.println(f.andThen(g).apply(1));

        Predicate<String> pf = o -> o.equals("test");
        Predicate<String> pg = o -> o.startsWith("t");

        Optional<String> of = Optional.ofNullable("empty");
        of.get();
    }
}
