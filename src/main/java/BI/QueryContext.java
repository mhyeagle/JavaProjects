package BI;

import lombok.Data;

@Data
public class QueryContext {
    private SearchContext searchContext;
    private MemoryCompute memoryCompute;
    private ResultContext resultContext;
}
