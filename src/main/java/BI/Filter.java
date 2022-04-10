package BI;

import lombok.Data;
import java.util.List;

@Data
public class Filter {
    private String key;                 // 筛选器对应的nameEn
    private List<String> values;        // 筛选值
    private OptTypeEnum optType;        // 筛选方式
}
