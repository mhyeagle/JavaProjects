package BI;

import lombok.Data;

@Data
public class RateTypeStrategyInfo {
    private String unfinishedFlagDimField;  //
    private RateTypeStrategyEnum rateTypeStrategy;
    private DateFormatEnum dateFormat;  // 日周月，日维度不生效
    private Boolean specialFormatFlag;  // 是否为特殊日号
    private String lastPeriodValue; // 上一周期值
    private String currentPeriodValue; // 本周期值
}
