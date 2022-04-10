//import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;
//import com.sankuai.meituan.waimai.feature.rankdata.thrift.vo.RankDataQueryItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MTJacksonUtils {
//    public static void main(String[] args) {
//        RankDataQueryItem rankDataQueryItem = new RankDataQueryItem();
//
//        List<Long> poiIdList = new ArrayList<>();
//        poiIdList.add(3930003L);
//        rankDataQueryItem.setPoiIdList(poiIdList);
//        List<Long> docIdList = new ArrayList<>();
//        docIdList.add(10216273L);
//        rankDataQueryItem.setDocIdList(docIdList);
//
//        String result = JacksonUtils.serialize(rankDataQueryItem);
//        System.out.println(result);
//    }
//}
