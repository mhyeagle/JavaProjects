//package meituanProj;
//
//import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;
//import com.sankuai.meituan.waimai.d.profile.feature.utvs.req.InstGetReq;
//import com.sankuai.meituan.waimai.thrift.feature.v2.vo.req.BatchInfo;
//import com.sankuai.meituan.waimai.thrift.feature.v2.vo.req.GenInstReq;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProfileArchive {
//    public static void main(String[] args) {
//        GenInstReq genInstReq = new GenInstReq();
//        genInstReq.setDocType(1);
//        genInstReq.setDocId(10593);
//        genInstReq.setMisId("miaohongyuan");
//        genInstReq.setMisName("苗宏远");
//        genInstReq.setInvokeType(1);
//        genInstReq.setDataGenType(1);
//
//        List<BatchInfo> batchInfos = new ArrayList<>();
//        batchInfos.add(new BatchInfo(0));
//        batchInfos.add(new BatchInfo(100));
//        genInstReq.setBatchInfos(batchInfos);
//
//        System.out.println("request: " + JacksonUtils.serialize(genInstReq));
//
//        InstGetReq req = new InstGetReq();
//        req.setId(37389L);
//        req.setPageSize(1000);
//        req.setPageId(5);
//        System.out.println("InstGetReq: " + JacksonUtils.serialize(req));
//    }
//}
