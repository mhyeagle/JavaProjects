package objectMap;

import java.util.HashMap;
import java.util.Map;

public class TestObjMap {
    public static void main(String[] args) {
        CreativeInfoPO creativeInfoPO = new CreativeInfoPO();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("creativeId", 1);
        map1.put("hour", "02");
        map1.put("noexist", "error");

        //***


        try {
            //creativeInfoPO = (CreativeInfoPO)ObjectMap.mapToObject(map1, CreativeInfoPO.class);
            creativeInfoPO = ObjectMap.map2Bean(map1, CreativeInfoPO.class);
            System.out.println(creativeInfoPO.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<?,?> map2 = ObjectMap.objectToMap(creativeInfoPO);
        System.out.println(map2.toString());
    }
}
