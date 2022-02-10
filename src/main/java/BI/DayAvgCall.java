package BI;

import lombok.Data;

@Data
public class DayAvgCall {
    private String dtKey;                       // 日纬度
    private Boolean rateTypeCalFlag;            // 是否计算同环比,当为true时,引用rateTypes信息
}
