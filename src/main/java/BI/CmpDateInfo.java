package BI;

import lombok.Data;

import java.util.List;

@Data
public class CmpDateInfo {
    private String key;                             // 日期分组的key
    private OptTypeEnum optType;                    // 日期筛选方式，默认为btween
    private List<CmpValue> cmpValues;               // 分组信息
}
