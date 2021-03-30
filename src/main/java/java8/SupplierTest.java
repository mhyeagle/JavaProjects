package java8;

import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> new Integer(0);

        Integer aI = supplier.get();
        aI = 10;
        Integer bI = supplier.get();

        List<String> list = new ArrayList<>();
        list.add("ouyunxi");
        String str = JacksonUtils.serialize(list);
        System.out.println(str);

        System.out.println("ai:" + aI.toString());
        System.out.println("bi:" + bI.toString());
    }
}
