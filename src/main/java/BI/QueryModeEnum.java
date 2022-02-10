package BI;

public enum QueryModeEnum {
    DSL(1, "DSL"),
    SQL(2, "SQL");

    private Integer mode;
    private String text;

    QueryModeEnum(Integer mode, String text) {
        this.mode = mode;
        this.text = text;
    }

    public static QueryModeEnum getByMode(Integer mode) {
        switch (mode) {
            case 1:
                return DSL;
            case 2:
                return SQL;
            default:
                throw new RuntimeException("查询类型错误");
        }
    }
}
