package BI;

import lombok.Data;

import java.util.List;

@Data
public class SearchContext {
    private Integer uid;            // 用户ID
    private Boolean isTest;         // 是否测试，根据该标志打印系统中详细的日志信息，便于问题排查定位
    private String appKey;          // 客户端appKey
    private String token;           // 用户Token
    private List<Query> querys;     // 查询信息

}
