package BI;

import lombok.Data;

import java.util.List;

public class Ratio {
    private List<String> ratioDims;                     // 占比对应的维度
    private List<RatioIndex> ratios;                    // 计算占比的指标

    @Data
    public static class RatioIndex {
        private String index;                           // 计算占比的原始指标的英文名
        private String deriveIndexName;                 // 结果指标（占比）的名称
        private String deriveIndexNameEn;               // 衍生指标的英文名称
    }
}
