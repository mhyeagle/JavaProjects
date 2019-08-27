import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONObjectTest {
    public static void main(String[] args) {
        String jsonStr1 = "{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"customized\",\"id\":123}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"push_ord_num_1d\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"10\"}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"push_ord_num_7d\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"11\"}}}}}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"like\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"poi_name\"}},\"right\":{\"expr\":{\"type\":\"expr_list\",\"value\":[{\"expr\":{\"type\":\"string\",\"value\":\"宏\"}}]}}}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"in\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"province_id\"}},\"right\":{\"expr\":{\"type\":\"expr_list\",\"value\":[{\"expr\":{\"type\":\"number\",\"value\":110000}}]}}}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"or\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"food_num\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"10\"}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"sale_stock_food_num\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"11\"}}}}}}}";
        String jsonStr2 = "{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"customized\",\"id\":123}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"and\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"push_ord_num_1d\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"10\"}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"push_ord_num_7d\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"11\"}}}}}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"like\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"poi_name\"}},\"right\":{\"expr\":{\"type\":\"expr_list\",\"value\":[{\"expr\":{\"type\":\"string\",\"value\":\"宏\"}}]}}}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"in\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"province_id\"}},\"right\":{\"expr\":{\"type\":\"expr_list\",\"value\":[{\"expr\":{\"type\":\"number\",\"value\":110000}}]}}}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\"or\",\"left\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"food_num\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"10\"}}}},\"right\":{\"expr\":{\"type\":\"binary_expr\",\"operator\":\">=\",\"left\":{\"expr\":{\"type\":\"column_ref\",\"model\":\"2\",\"column\":\"sale_stock_food_num\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"11\"}}}}}}}}";
        String jsonStr = "{\"expr\":{\"left\":{\"expr\":{\"left\":{\"expr\":{\"left\":{\"expr\":{\"left\":{\"expr\":{\"id\":123,\"type\":\"customized\"}},\"right\":{\"expr\":{\"left\":{\"expr\":{\"left\":{\"expr\":{\"column\":\"push_ord_num_1d\",\"model\":\"2\",\"type\":\"column_ref\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"10\"}},\"type\":\"binary_expr\",\"operator\":\">=\"}},\"right\":{\"expr\":{\"left\":{\"expr\":{\"column\":\"push_ord_num_7d\",\"model\":\"2\",\"type\":\"column_ref\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"11\"}},\"type\":\"binary_expr\",\"operator\":\">=\"}},\"type\":\"binary_expr\",\"operator\":\"and\"}},\"type\":\"binary_expr\",\"operator\":\"and\"}},\"right\":{\"expr\":{\"left\":{\"expr\":{\"column\":\"poi_name\",\"model\":\"2\",\"type\":\"column_ref\"}},\"right\":{\"expr\":{\"type\":\"expr_list\",\"value\":[{\"expr\":{\"type\":\"string\",\"value\":\"宏\"}}]}},\"type\":\"binary_expr\",\"operator\":\"like\"}},\"type\":\"binary_expr\",\"operator\":\"and\"}},\"right\":{\"expr\":{\"left\":{\"expr\":{\"column\":\"province_id\",\"model\":\"2\",\"type\":\"column_ref\"}},\"right\":{\"expr\":{\"type\":\"expr_list\",\"value\":[{\"expr\":{\"type\":\"number\",\"value\":110000}}]}},\"type\":\"binary_expr\",\"operator\":\"in\"}},\"type\":\"binary_expr\",\"operator\":\"and\"}},\"right\":{\"expr\":{\"left\":{\"expr\":{\"left\":{\"expr\":{\"column\":\"food_num\",\"model\":\"2\",\"type\":\"column_ref\"}},\"right\":{\"expr\":{\"type\":\"string\",\"value\":\"10\"}},\"type\":\"binary_expr\",\"operator\":\">=\"}},\"right\":{\"expr\":{\"type\":\"customized\",\"id\":234}},\"type\":\"binary_expr\",\"operator\":\"or\"}},\"type\":\"binary_expr\",\"operator\":\"and\"}}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);

        System.out.println(jsonObject.toJSONString());
        travelJsonObj(jsonObject);
        System.out.println(jsonObject.toJSONString());
    }

    public static void travelJsonObj(JSONObject jsonObject) {
        if (jsonObject.getJSONObject("expr").containsKey("left")) {
            travelJsonObj(jsonObject.getJSONObject("expr").getJSONObject("left"));
        }

        if (jsonObject.getJSONObject("expr").containsKey("right")) {
            travelJsonObj(jsonObject.getJSONObject("expr").getJSONObject("right"));
        }

        if ("customized".equals(jsonObject.getJSONObject("expr").getString("type"))) {
            // 替换expr为自定义标签
            //Long labelId = jsonObject.getJSONObject("expr").getLong("id");
            JSONObject obj = new JSONObject();
            obj.put("type", "newCustom");
            obj.put("test1", "test1");
            obj.put("test2", "test2");
            jsonObject.put("expr", obj);
        }
    }
}
