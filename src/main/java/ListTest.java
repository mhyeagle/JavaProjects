import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;

public class ListTest {
    private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    public static void main(String[] args) {
        LinkedList<String> words = new LinkedList<>();

        words.add("a");
        words.add("b");
        words.add("c");

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
            logger.info("{}", words.get(i));
        }
    }
}
