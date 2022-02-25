//package meituanProj;
//
//import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;
//import com.google.common.collect.Lists;
//import com.sankuai.meituan.waimai.d.profile.feature.utvs.enums.ImportType;
//import com.sankuai.meituan.waimai.d.profile.feature.utvs.req.InstGenReq;
//import com.sankuai.meituan.waimai.d.profile.feature.utvs.req.InstGetReq;
//import com.sankuai.meituan.waimai.d.profile.feature.utvs.req.InstSearchReq;
//import com.sankuai.meituan.waimai.d.profile.ups.req.PortraitOneDocReq;
//import com.sankuai.meituan.waimai.d.profile.ups.req.PortraitOneReq;
//import com.sankuai.meituan.waimai.feature.rankdata.thrift.vo.RankDataQueryItem;
//import com.sankuai.meituan.waimai.thrift.feature.v2.vo.req.GenInstReq;
//import com.sankuai.meituan.waimai.thrift.feature.v2.vo.req.PreviewReq;
//import objectMap.CreativeInfoPO;
//import org.apache.thrift.TBase;
//import org.apache.thrift.TException;
//import org.apache.thrift.TSerializer;
//import org.apache.thrift.protocol.TSimpleJSONProtocol;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.springframework.beans.factory.BeanCreationException;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JacksonTest {
//    public static void main(String[] args) {
//        ObjectMapper mapper = new ObjectMapper();
//
//        RankDataQueryItem rankDataQueryItem = new RankDataQueryItem();
//        List<Long> poiIdList = new ArrayList<Long>();
//        poiIdList.add(3930003L);
//        rankDataQueryItem.setPoiIdList(poiIdList);
//        List<Long> docIdList = new ArrayList<>();
//        docIdList.add(10216273L);
//        rankDataQueryItem.setDocIdList(docIdList);
//        List<Integer> instIds = new ArrayList<>();
//        instIds.add(10433245);
//
////        try {
////            String json = mapper.writeValueAsString(creativeInfoPO);
////
////            System.out.println(json);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        String serStr = JacksonUtils.serialize(instIds);
//        System.out.println(serStr);
//
//
////        TSerializer serializer = new TSerializer(new TSimpleJSONProtocol.Factory());
////        try {
////
////            String json = serializer.toString(rankDataQueryItem);
////            System.out.println(json);
////        } catch (TException e) {
////            e.printStackTrace();
////        }
//
//        List<Integer> docIds = new ArrayList<>();
////        docIds.add(7382);
//        docIds.add(9077);
//        String creator = "miaohongyuan";
//        String idsStr = JacksonUtils.serialize(docIds);
//
//        Integer id1 = 7609;
//
//        System.out.println("ids:" + idsStr);
//        System.out.println("creator:" + JacksonUtils.serialize(creator));
//        System.out.println("int id1:" + JacksonUtils.serialize(id1));
//
//        PortraitOneDocReq docReq = new PortraitOneDocReq();
//        docReq.setDimId(1);
//        docReq.setDocIds(Lists.newArrayList(11539));
//        docReq.setKey("55341");
//
//        System.out.println("docReq:" + JacksonUtils.serialize(docReq));
//
//        PortraitOneReq portraitOneReq = new PortraitOneReq();
//        portraitOneReq.setDimId(1);
//        portraitOneReq.setIsEnglishLabelName(true);
//        portraitOneReq.setKey("1062882367");
//        portraitOneReq.setClientAppKey("quake-agent");
//        portraitOneReq.setSecret("5da5ec7f8111714328f65774a8b01426");
//
//        System.out.println("portaitOneReq: " + JacksonUtils.serialize(portraitOneReq));
//
//        PreviewReq previewReq = new PreviewReq(1, "", 1, 1);
//        System.out.println("PreviewReq: " + JacksonUtils.serialize(previewReq));
//
//        InstGetReq instGetReq = new InstGetReq();
//        instGetReq.setId(174L);
//        instGetReq.setPageId(9);
//        instGetReq.setPageSize(1000);
//        System.out.println("instGetReq: " + JacksonUtils.serialize(instGetReq));
//
//        InstSearchReq instSearchReq = new InstSearchReq();
//        instSearchReq.setDimId(7);
//        instSearchReq.setId(100001177L);
////        instSearchReq.setDataType(ImportType.UUID);
//        instSearchReq.setPageId(1);
//        instSearchReq.setPageSize(1);
//        System.out.println("instSearchReq: " + JacksonUtils.serialize(instSearchReq));
//
//        GenInstReq genInstReq = new GenInstReq();
//
//        InstGenReq instGenReq = new InstGenReq();
//        instGenReq.setDimId(7);
//        instGenReq.setName("20210201-question2-mhy");
//        instGenReq.setDocId(100000178L);
//        instGenReq.setImportType(ImportType.USERID);
//        instGenReq.setExecutor("miaohongyuan");
//        System.out.println("instGenReq: " + JacksonUtils.serialize(instGenReq));
//
//        com.sankuai.meituan.waimai.d.profile.feature.utvs.req.PreviewReq previewReq1 = new com.sankuai.meituan.waimai.d.profile.feature.utvs.req.PreviewReq();
//        previewReq1.setDimId(7);
//        previewReq1.setIndexDate("20210328");
//        previewReq1.setSearchSource("{\"type\":\"and\",\"config\":{\"conditions\":[{\"type\":\"in\",\"config\":{\"field\":\"predict_gender\",\"values\":[\"0\"]}}]}}");
//        System.out.println("previewReq1:" + JacksonUtils.serialize(previewReq1));
//    }
//}
