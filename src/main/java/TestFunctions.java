import java.util.ArrayList;
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
    }
}
