package BI;

import lombok.Data;

import java.util.List;

@Data
public class ReferenceValue {
    private String key;
    private List<String> dims;
    private GroupTypeEnum groupType;
    private StatTypeEnum statType;

    public enum GroupTypeEnum {
        GROUP_STAT(1, "GROUP_STAT"),
        ALL_STAT(2, "ALL_STAT");

        private Integer type;
        private String text;

        GroupTypeEnum(Integer type, String text) {
            this.type = type;
            this.text = text;
        }
    }
}
