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

//        try {
//            String json = mapper.writeValueAsString(creativeInfoPO);
//
//            System.out.println(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        TSerializer serializer = new TSerializer(new TSimpleJSONProtocol.Factory());
        try {
            String json = serializer.toString(rankDataQueryItem);
            System.out.println(json);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
