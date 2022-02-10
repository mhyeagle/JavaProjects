package BI;

import lombok.Data;

@Data
public class SortInfo {
    private String key;                 // 排序字段
    private SortTypeEnum sortType;      // 排序方式

    public enum SortTypeEnum {
        ASC(1, "ASC"),
        DESC(2, "DESC");

        private Integer type;
        private String text;

        SortTypeEnum(Integer type, String text) {
            this.type = type;
            this.text = text;
        }

        public static SortTypeEnum getByType(Integer type) {
            switch (type) {
                case 1:
                    return ASC;
                case 2:
                    return DESC;
                default:
                    throw new RuntimeException("排序类型异常");
            }
        }
    }
}
