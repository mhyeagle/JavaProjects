import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;
import com.sankuai.meituan.waimai.feature.rankdata.thrift.vo.RankDataQueryItem;
import objectMap.CreativeInfoPO;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.BeanCreationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonTest {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        RankDataQueryItem rankDataQueryItem = new RankDataQueryItem();
        List<Long> poiIdList = new ArrayList<Long>();
        poiIdList.add(3930003L);
        rankDataQueryItem.setPoiIdList(poiIdList);
        List<Long> docIdList = new ArrayList<>();
        docIdList.add(10216273L);
        rankDataQueryItem.setDocIdList(docIdList);
        List<Integer> instIds = new ArrayList<>();
        instIds.add(10433245);

//        try {
//            String json = mapper.writeValueAsString(creativeInfoPO);
//
//            System.out.println(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String serStr = JacksonUtils.serialize(instIds);
        System.out.println(serStr);


//        TSerializer serializer = new TSerializer(new TSimpleJSONProtocol.Factory());
//        try {
//
//            String json = serializer.toString(rankDataQueryItem);
//            System.out.println(json);
//        } catch (TException e) {
//            e.printStackTrace();
//        }

        List<Integer> docIds = new ArrayList<>();
        docIds.add(7382);
        docIds.add(7609);
        String creator = "miaohongyuan";
        String idsStr = JacksonUtils.serialize(docIds);

        Integer id1 = 7609;

        System.out.println("ids:" + idsStr);
        System.out.println("creator:" + JacksonUtils.serialize(creator));
        System.out.print("int id1:" + JacksonUtils.serialize(id1));
    }
}
