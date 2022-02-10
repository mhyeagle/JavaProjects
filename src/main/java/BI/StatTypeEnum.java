package BI;

public enum StatTypeEnum {
    SUM(1, "SUM"),
    COUNT(2, "COUNT"),
    MAX(3, "MAX"),
    MIN(4, "MIN"),
    AVG(5, "AVG"),
    MEDIAN(6, "MEDIAN");

    private Integer type;               // 统计方式
    private String text;                // 统计方式名称

    StatTypeEnum(Integer type, String text) {
        this.type = type;
        this.text = text;
    }

    public static StatTypeEnum getByType(Integer type) {
        switch (type) {
            case 1:
                return SUM;
            case 2:
                return COUNT;
            case 3:
                return MAX;
            case 4:
                return MIN;
            case 5:
                return AVG;
            case 6:
                return MEDIAN;
            default:
                throw new RuntimeException("统计方式参数异常");
        }
    }
}
