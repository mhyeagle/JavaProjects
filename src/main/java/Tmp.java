import java.util.*;

public class Tmp {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.forEach((k, v) -> System.out.println("key " + k + ",value " + v));
    }
}
