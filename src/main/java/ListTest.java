import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ListTest {
    private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    public static void main(String[] args) {
        LinkedList<String> words = new LinkedList<>();

        words.add("a");
        words.add("b");
        words.add("c");

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.sort((o1, o2) -> o2 - o1);

        System.out.println(nums.toString());

        for (String s : words) {
            if (s.equals("b")) {
                words.remove(s);
                continue;
            }
            System.out.println(s);
        }

        Iterator it = words.iterator();

//        int num = 0;
//        while (it.hasNext()) {
//            logger.info("{}", it.next());
//            if (num == 2) {
//                words.add("2");
//            }
//            num++;
//        }

        for (int i = 0; i < words.size(); i++) {
            if (i == 2) {
                words.add("2");
                words.set(2, "1024");
            }
            logger.info("Mhy logger:{}", words.get(i));
        }

        Boolean nullIsMap = null instanceof Map;
        System.out.println("null Is Map: " + nullIsMap);

        List<Integer> arr = new ArrayList<>(3);
//        arr.set(1, 2);
        System.out.println("");

        String splitedStr = "ab,";
        String[] arrStr = splitedStr.split(",");
        List<String> li = Arrays.asList(arrStr);

        // List<Long> contains
        List<Long> listLongs = new ArrayList<>();
        listLongs.add(1L);
        listLongs.add(10000L);
        Long containId = 10000L;
        if (listLongs.contains(containId)) {
            System.out.println("ListLongs contains");
        } else {
            System.out.println("ListLongs not contains Long");
        }

    }
}
