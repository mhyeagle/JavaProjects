import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestFunctions {
    public static void main(String[] args) {
        String str = "20180123";
        System.out.println(str.substring(6));

        //***1***
        Map<String, List<Long>> data = new ConcurrentHashMap<String, List<Long>>();
        List<Long> list1 = new ArrayList<Long>();
        list1.add(1L);
        list1.add(2L);
        data.put("test", list1);

        List<Long> list2 = data.get("test");
        list2.add(10L);

        List<Long> list3 = data.get("test");
        System.out.println(list3);

        //***2***
        List<Long> list4 = new ArrayList<Long>();
        List<Long> list5 = new ArrayList<Long>();
        list4.add(1L);
        list5 = list4;
        list4 = new ArrayList<Long>();
        list4.add(2L);
        System.out.println("list5" + list5.toString());

        //***3***
        System.out.println("***3***");
        str = "123";
        String[] words = str.split("123");
        for (String word: words) {
            System.out.println(word);
        }
        System.out.println("words length: " + words.length);

        //***4***
        System.out.println("***4***");
        LinkedList<String> llist = new LinkedList<>();
        llist.add("1");
        llist.add("2");
        llist.add("3");
        System.out.println(llist.toString());
    }
}
