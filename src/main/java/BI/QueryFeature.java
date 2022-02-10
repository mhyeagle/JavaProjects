package BI;

import lombok.Data;

import java.util.List;

@Data
public class QueryFeature {
    private List<SortInfo> sortInfoList;                        // 排序信息
    private List<DayAvgCall> dayAvgCallInfo;                    // 日均计算信息
    private List<RateType> rateTypes;                           // 同环比
    private List<StatInfo> statInfos;                           // 统计值
    private List<Ratio> ratios;                                 // 占比
    private List<ReferenceValue> referenceValueInfo;            // 参考值
    private List<DTRef> dtRefInfo;                              // 日期维度的衍生计算
    private DrillInfo drillInfo;                                // 下钻信息
    private List<CmpDimInfo> cmpDimInfos;                       // 维度分组信息
    private List<CmpIndexInfo> cmpIndexInfos;                   // 指标分段信息
    private List<CmpDateInfo> cmpDateInfo;                      // 日期分组
    private List<CustomizeColumn> customizeInfo;                // 自定义指标/维度
    private String realTimeFilter;                              // 实时筛选器,需要确认实时筛选器的时间格式，如yyyymmddHHMMSS
    private RateTypeStrategyInfo unfinishedRateType;            // 未过完的周和月同环比
    // TODO
    // private SpecialDateFormateEnum specialDateFormate;          // 特殊日期
}
