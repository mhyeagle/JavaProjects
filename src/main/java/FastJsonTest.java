import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

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

        System.out.println("------4-----");
        JsonFieldName jsonFieldName = new JsonFieldName("jiannan_road");
        String jsonFieldStr = JSONObject.toJSONString(jsonFieldName);
        System.out.println("result4:" + jsonFieldStr);
        JsonFieldName jsonFieldName2 = JSONObject.parseObject(jsonFieldStr, JsonFieldName.class);
        //JSONObject.parseObject(jsonFieldStr, new TypeReference<Map<String, Integer>>(){});
        //JsonFieldName jsonFieldName2 = JSONObject.toJavaObject(JSONObject.parseObject(jsonFieldStr), JsonFieldName.class);
        System.out.println("result4-2:" + jsonFieldName2.toString());
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

    @Data
    public static class JsonFieldName {
        @JSONField(name = "master_road")
        private String masterRoad;

        @JSONCreator
        public JsonFieldName(String name) {
            masterRoad = name;
        }
    }
}
