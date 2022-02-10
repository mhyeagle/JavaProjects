package BI;

import lombok.Data;

import java.util.List;

@Data
public class RateType {
    private CategoryOfRateType type;                           // 同环比类型
    private Boolean yoyRateFlag;                               // 是否是节假日年同比,只有日纬度下才生效
    private String dim;                                        // 同环比计算的维度
    private Integer offset;                                    // 日维度下对比7天，offset=7；周维度下对比1周，offset=1；月维度下对比1月，offset=1；yoy年同比传固定偏移:364
    private List<RateIndex> rateIndexInfo;                     // 同环比计算的指标信息


    @Data
    public static class RateIndex {
        private String index;                                   // 计算同环比原始指标的英文名
        private String deriveIndexName;                         // 结果衍生指标（同环比）中文名
    }


    public enum CategoryOfRateType {
        SIMI_CHAIN_RATE_TYPE(1, "同环比"),          // 同环比
        SIMI_CHAIN_DIFF_TYPE(2, "同环比差"),        // 同环比差值
        SIMI_PERIOD_TYPE(3, "同期(基期)");          // 同期(基期)

        private Integer type;
        private String text;

        CategoryOfRateType(Integer type, String text) {
            this.type = type;
            this.text = text;
        }
    }
}
