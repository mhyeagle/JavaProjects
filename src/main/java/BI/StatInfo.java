package BI;

import lombok.Data;

import java.util.List;

@Data
public class StatInfo {
    private String key;                         // 指标英文名
    private List<StatTypeEnum> types;               // 一个统计对象可以有多种统计方式
}
