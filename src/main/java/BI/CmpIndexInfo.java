package BI;

import lombok.Data;

import java.util.List;

@Data
public class CmpIndexInfo {
    private String key;
    private String index;
    private List<CmpValue> cmpValues;
}
