package BI;

public enum DateFormatEnum {

    DT(1),
    WK(2),
    MO(3);


    private Integer dateFormat;

    DateFormatEnum(Integer dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Integer getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(Integer dateFormat) {
        this.dateFormat = dateFormat;
    }
}
