package BI;

import lombok.Data;

import java.util.Map;

@Data
public class MemoryCompute {
    private Map<String, Expression> extIndex2Expr;
}
