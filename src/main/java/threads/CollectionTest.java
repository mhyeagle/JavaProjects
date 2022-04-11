package threads;

import java.util.HashSet;
import java.util.Set;

public class CollectionTest {
    public static void main(String[] args) {
        Set<String> tmpSet = new HashSet<>();
        tmpSet.add("a");
        tmpSet.add("b");

        System.out.println(tmpSet);
    }
}
