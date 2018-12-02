import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Map;

public class FastJsonTest {
    public static void main(String[] args) {
        String json_str = "{\"gender\":10,\"age\":20}";
        Map<String, Integer> kv = (Map) JSON.parse(json_str);

        System.out.println(kv.toString());

        if (kv.containsKey("gender")) {
            System.out.println("gender: " + kv.get("gender"));
        }
        if (kv.containsKey("age")) {
            System.out.println("age: " + kv.get("age"));
        }

        System.out.println("-----------");
        json_str = "[{\"id\":12356,\"gender\":10,\"age\":20},{\"id\":12357,\"gender\":11,\"age\":22}]";
        JSONArray array = JSONArray.parseArray(json_str);

        int arraySize = array.size();
        for (int i = 0; i < arraySize; i++) {
            Map<String, Integer> kv_tmp = (Map)array.get(i);

            for (Map.Entry<String, Integer> entry : kv_tmp.entrySet()) {
                System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue().intValue());
            }

            System.out.println("");
        }
    }
}
