package ES.Expr;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
@Slf4j
public class Query implements AbstractQuery {
    public static final String NAME = "bool";
    /**
     * 组合查询，and
     */
    private List<AbstractQuery> filterList;
    /**
     * 组合查询，or
     */
    private List<AbstractQuery> shouldList;
    /**
     * 组合查询，not
     * @return
     */
    private List<AbstractQuery> notList;

    @Override
    public String getName() {
        return NAME;
    }

    public Query filter(AbstractQuery query) throws Exception {
        if (null == query) {
            throw new Exception("参数为null");
        }

        if (filterList == null) {
            filterList = new ArrayList<>();
        }

        filterList.add(query);

        return this;
    }

    public Query should(AbstractQuery query) throws Exception {
        if (null == query) {
            throw new Exception("参数为null");
        }

        if (shouldList == null) {
            shouldList = new ArrayList<>();
        }

        shouldList.add(query);

        return this;
    }

    public Query not(AbstractQuery query) throws Exception {
        if (null == query) {
            throw new Exception("参数为null");
        }

        if (notList == null) {
            notList = new ArrayList<>();
        }

        notList.add(query);

        return this;
    }

    public String serializable() throws Exception {
        QueryBuilder queryBuilder = convertQuery(this);

        return queryBuilder.toString();
    }

    /**
     * 递归的转换为ES的查询格式
     * @param query
     * @return
     * @throws Exception
     */
    public QueryBuilder convertQuery(AbstractQuery query) throws Exception {
        String name = query.getName();
        switch (name) {
            case "bool":
                BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
                Query boolQuery = (Query) query;
                if (boolQuery.getFilterList() != null) {
                    for (AbstractQuery abstractQuery : boolQuery.getFilterList()) {
                        boolQueryBuilder.filter(convertQuery(abstractQuery));
                    }
                }

                if (boolQuery.getShouldList() != null) {
                    for (AbstractQuery abstractQuery : boolQuery.getShouldList()) {
                        boolQueryBuilder.should(convertQuery(abstractQuery));
                    }
                }

                if (boolQuery.getNotList() != null) {
                    for (AbstractQuery abstractQuery : boolQuery.getNotList()) {
                        boolQueryBuilder.mustNot(convertQuery(abstractQuery));
                    }
                }

                return boolQueryBuilder;

            case "terms":
                Terms terms = (Terms) query;
                if (!checkTermsValid(terms)) {
                    throw new Exception("terms:" + terms.getFieldName() + "格式异常");
                }
                return new TermsQueryBuilder(terms.getFieldName(), terms.getValues());

            case "range":
                Range range = (Range) query;
                if (!checkRangeValid(range)) {
                    throw new Exception("terms:" + range.getFieldName() + "格式异常");
                }
                RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder(range.getFieldName());
                rangeQueryBuilder.from(range.getFrom());
                rangeQueryBuilder.to(range.getTo());
                rangeQueryBuilder.includeLower(range.isIncludeLower());
                rangeQueryBuilder.includeUpper(range.isIncludeUpper());

                return rangeQueryBuilder;

            default:
                return null;
        }
    }

    /**
     * 检查range查询是否参数错误
     *
     * @param range
     * @return
     */
    private boolean checkRangeValid(Range range) {
        if (range != null &&
                (range.getFrom() != null || range.getTo() != null)) {
            return true;
        }

        return false;
    }

    /**
     * 检查term查询是否参数错误
     *
     * @param terms
     * @return
     */
    private boolean checkTermsValid(Terms terms) {
        if (terms != null
                && StringUtils.isNotEmpty(terms.getFieldName())
                && terms.getValues().size() > 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        Query query = new Query();

        Terms term1 = new Terms();
        term1.setFieldName("f1");
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        term1.setValues(list1);

        Range range1 = new Range();
        range1.setFieldName("age");
        range1.setFrom(1);
        range1.setTo(10);
        range1.setIncludeLower(false);


        List<AbstractQuery> filterList1 = new ArrayList<>();
        filterList1.add(term1);
        filterList1.add(range1);

//        query.setFilterList(filterList1);
//        query.setNotList(filterList1);
        query.filter(term1);
        query.should(term1);
        query.not(term1);

        query.not(range1);


        Query queryE = new Query();
        List<AbstractQuery> shouldList1 = new ArrayList<>();
        shouldList1.add(query);
        shouldList1.add(term1);
        queryE.setShouldList(shouldList1);

        String searchStr = query.serializable();

        System.out.println("searchStr:" + searchStr);

        System.out.println("search: " + JSONObject.toJSONString(searchStr, true));
    }
}
