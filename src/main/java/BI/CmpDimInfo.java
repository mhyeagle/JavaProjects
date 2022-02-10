package BI;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CmpDimInfo implements Serializable {
    private String cmpKey;
    private String table;
    private List<DimGroupInfo> groups;

    @Data
    public static class DimGroupInfo {
        private Long groupId;
        private String groupName;
    }
}
