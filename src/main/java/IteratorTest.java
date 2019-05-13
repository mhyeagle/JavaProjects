import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");

        Iterator<String> itr = list.iterator();
        while(itr.hasNext()) {
            String str = itr.next();

            if (str.equals("b")) {
                System.out.println("remove element b");
                itr.remove();
            }
        }

        System.out.println("******");
        for (String it : list) {
            if (it.equals("c")) {
                //list.remove(it);
            }
            System.out.println(it);
        }
    }
}
