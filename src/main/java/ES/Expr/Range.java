package ES.Expr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Range implements AbstractQuery {
    public static final String NAME = "range";
    public static final boolean DEFAULT_INCLUDE_UPPER = true;
    public static final boolean DEFAULT_INCLUDE_LOWER = true;
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段起始值
     */
    private Object from;
    /**
     * 字段最大值
     */
    private Object to;
    /**
     * 是否包含下边界
     */
    private boolean includeLower = DEFAULT_INCLUDE_LOWER;
    /**
     * 是否包含上边界
     */
    private boolean includeUpper = DEFAULT_INCLUDE_UPPER;

    /**
     * 不包含range下边界
     * @param from
     */
    public void gt(Object from) {
        setFrom(from);
        setIncludeLower(false);
    }

    /**
     * 包含range下边界
     * @param from
     */
    public void gte(Object from) {
        setFrom(from);
    }

    /**
     * 不包含range上边界
     * @param to
     */
    public void lt(Object to) {
        setTo(to);
        setIncludeUpper(false);
    }

    /**
     * 包含range上边界
     * @param to
     */
    public void lte(Object to) {
        setTo(to);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
