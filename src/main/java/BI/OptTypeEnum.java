package BI;

public enum OptTypeEnum {
    EQUAL(1, "EQUAL"),
    BETWEEN(2, "BETWEEN"),
    NOT(3, "NOT"),
    IN(4, "IN"),
    GREAT(5, "GREAT"),
    GREATEQUAL(6, "GREATEQUAL"),
    LESS(7, "LESS"),
    LESSEQUAL(8, "LESSEQUAL"),
    HEADLIKE(9, "HEADLIKE"),
    TAILLIKE(10, "TAILLIKE"),
    LIKE(11, "LIEK"),
    NOTIN(12, "NOTIN"),
    IS(13, "IS"),
    ISNOT(14, "ISNOT");

    private Integer type;
    private String text;

    OptTypeEnum(Integer type, String text) {
        this.type = type;
        this.text = text;
    }

    public static OptTypeEnum getByType(Integer type) {
        switch (type) {
            case 1:
                return EQUAL;
            case 2:
                return BETWEEN;
            case 3:
                return NOT;
            case 4:
                return IN;
            case 5:
                return GREAT;
            case 6:
                return GREATEQUAL;
            case 7:
                return LESS;
            case 8:
                return LESSEQUAL;
            case 9:
                return HEADLIKE;
            case 10:
                return TAILLIKE;
            case 11:
                return LIKE;
            case 12:
                return NOTIN;
            case 13:
                return IS;
            case 14:
                return ISNOT;
            default:
                throw new RuntimeException("过滤类型异常");
        }
    }
}
