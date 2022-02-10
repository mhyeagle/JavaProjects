package BI;

import lombok.Data;

@Data
public class DrillInfo {
    private String key;                     // 下钻key，当前下钻的维度
    private DrillTypeEnum drillType;        // 下钻类型

    public enum DrillTypeEnum {
        DRILL_SLEF_TYPE(1, "DRILL_SLEF_TYPE"),
        DRILL_HIERARCHY_TYPE(2, "DRILL_HIERARCHY_TYPE");

        private Integer type;               // 下钻类型
        private String text;

        DrillTypeEnum(Integer type, String text) {
            this.type = type;
            this.text = text;
        }
    }
}
