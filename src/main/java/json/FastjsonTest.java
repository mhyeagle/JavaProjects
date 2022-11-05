package json;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

public class FastjsonTest {
    public static void main(String[] args) {
        String source = "[{\"sql\":[],\"uuid\":\"bind$0$0-2OPSdFRm5lphUYN2iYOzg\"}]";
        List<AreaSql> areaSqlList = JSONObject.parseArray(source, AreaSql.class);
        System.out.println("");
    }

    @Data
    public static class AreaSql {
        String uuid;
        List<String> sql;
    }

}
