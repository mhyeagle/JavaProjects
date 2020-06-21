package ES.Expr;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Terms implements AbstractQuery {
    public static final String NAME = "terms";
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段值list
     */
    private List<?> values;

    @Override
    public String getName() {
        return NAME;
    }
}
