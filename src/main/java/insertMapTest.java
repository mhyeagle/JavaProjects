import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class insertMapTest {
    private static Map<Long, List<Long>> planUnit2CreativeWriteMap = new ConcurrentHashMap<Long, List<Long>>();

    public static void main(String[] args) {
        insertPlanUnitMap(1679L, 1L);
        insertPlanUnitMap(1679L, 2L);

        System.out.println(planUnit2CreativeWriteMap.toString());
    }

    private static void insertPlanUnitMap(Long id, Long creativeId) {
        try {
            if (planUnit2CreativeWriteMap.containsKey(id)) {
                List<Long> values = planUnit2CreativeWriteMap.get(id);
                values.add(creativeId);
            } else {
                List<Long> creativeList = new ArrayList<Long>();
                creativeList.add(creativeId);
                planUnit2CreativeWriteMap.put(id, creativeList);
            }
        } catch (Exception e) {
            //System.out.println("id:{}, creativeId:{}, planUnit2CreativeWriteMap:{}", id, creativeId, planUnit2CreativeWriteMap);
            System.out.println(e.toString());
        }
    }
}
