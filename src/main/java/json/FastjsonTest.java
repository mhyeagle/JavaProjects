package json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.List;

/**
 * enum字段的反序列化
 */
public class FastjsonTest {
    public static void main(String[] args) {
        String source = "[{\"sql\":[],\"uuid\":\"bind$0$0-2OPSdFRm5lphUYN2iYOzg\",\"type\":\"dim\"}]";
        List<AreaSql> areaSqlList = JSONObject.parseArray(source, AreaSql.class);
        System.out.println("");
    }

    @Data
    public static class AreaSql extends Base {
        String uuid;
        List<String> sql;
    }

    @Data
    public static class Base {
        @JSONField(deserializeUsing = ColumTypeDeserializer.class)
        private ColumnType type;
    }

    public enum ColumnType {
        DIM("dim"),
        INDEX("index"),
        VAR("var");

        private String type;

        ColumnType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class ColumTypeDeserializer implements ObjectDeserializer {

        @SuppressWarnings("unchecked")
        @Override
        public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
            String value = defaultJSONParser.parseObject(String.class);
            for (ColumnType columnType : ColumnType.values()) {
                if (columnType.getType().equals(value)) {
                    return (T) columnType;
                }
            }

            return null;
        }

        @Override
        public int getFastMatchToken() {
            // 仅仅匹配字符串类型的值
            return JSONToken.LITERAL_STRING;
        }
    }
}
