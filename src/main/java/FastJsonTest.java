import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FastJsonTest {
    public static void main(String[] args) {
        String json_str = "{\"gender\":10,\"age\":20}";
        Map<String, Integer> kv = (Map) JSON.parse(json_str);

        JSONObject jsonObj = JSONObject.parseObject(json_str);

        System.out.println(kv.toString());

        if (kv.containsKey("gender")) {
            System.out.println("gender: " + kv.get("gender"));
        }
        if (kv.containsKey("age")) {
            System.out.println("age: " + kv.get("age"));
        }

        Long noExistLong = jsonObj.getLong("noExistLong");
        if (noExistLong == null) {
            System.out.println("noExistLong = null");
        } else {
            System.out.println("noExistLong: " + noExistLong);
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

        System.out.println("------3-----");
        ArrayList<String> arr = new ArrayList<>();
        arr.add("path1");
        arr.add("path2");
        arr.add("path3");
        JSONObject result3 = insertElement(arr, "abc");
        System.out.println("result3:" + result3.toJSONString());
    }


    private static JSONObject insertElement(List<String> paths, String label) {
        JSONObject result = new JSONObject();
        JSONObject element = result;
        for (int i = paths.size() - 1; i >= 0; i--) {
            String pathName = paths.get(i);
            JSONObject obj = new JSONObject();
            element.put(pathName, obj);
            element = obj;
        }

        element.put(label, 0);

        return result;
    }
}
