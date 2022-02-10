package BI;

import lombok.Data;

@Data
public class CmpValue {
    private String start;
    private String end;
    private String groupValueName;  // 分组的筛选值
    private String groupName;       // 分组名称，用户输入
    private Integer serialNum;      // 分组序号，从1开始
}
