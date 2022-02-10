package BI;

import lombok.Data;

import java.util.List;

@Data
public class Query {
    private List<String> dims;                                  // 维度信息
    private List<String> indexes;                               // 指标信息
    private AggTypeEnum aggType;                                // 聚合类型
    private List<Filter> filters;                               // 筛选器
    private PageInfo pageInfo;                                  // 页面信息
    private List<QueryFeature> queryFeatures;                   // 查询特征
    private QueryTypeEnum queryTypeEnum;                        // count 或者 数据查询
    private QueryModeEnum queryModeEnum;                        // DSL / SQL 查询
    private QuerySource querySource;                            // 查询数据的来源，hive或者数据集
    private Long datasetId;                                     // 数据集ID
    private String dsl;                                         // 查询dsl

    public enum AggTypeEnum {
        AGG(1, "AGG"),
        DETAIL(2, "DETAIL");

        private Integer type;
        private String text;

        AggTypeEnum(Integer type, String text) {
            this.type = type;
            this.text = text;
        }

        public static AggTypeEnum getByType(Integer type) {
            switch (type) {
                case 1:
                    return AGG;
                case 2:
                    return DETAIL;
                default:
                    throw new RuntimeException("请求下游的聚合参数错误");
            }
        }
    }

    public enum QueryTypeEnum {
        COUNT(1, "COUNT"),
        DATA(2, "DATA");

        private Integer type;
        private String text;

        QueryTypeEnum(Integer type, String text) {
            this.type = type;
            this.text = text;
        }

        public static QueryTypeEnum getByType(Integer type) {
            switch (type) {
                case 1:
                    return COUNT;
                case 2:
                    return DATA;
                default:
                    throw new RuntimeException("");
            }
        }
    }
}
