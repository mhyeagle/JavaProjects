//package meituanProj;
//
//import com.google.common.collect.Lists;
//import com.meituan.service.mobile.mtthrift.proxy.ThriftClientProxy;
//import com.sankuai.meituan.waimai.d.profile.ups.req.PortraitOneDocReq;
//import com.sankuai.meituan.waimai.d.profile.ups.req.PortraitOneReq;
//import com.sankuai.meituan.waimai.d.profile.ups.resp.PortraitOneResp;
//import com.sankuai.meituan.waimai.d.profile.ups.service.PortraitService;
//import javafx.application.Application;
//import org.apache.thrift.TException;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class PortraitTest {
//    @Autowired
//    private static PortraitService portraitService;
//
//    public static void main(String[] args) throws TException {
//        PortraitOneDocReq docReq = new PortraitOneDocReq();
//        docReq.setDimId(1);
//        docReq.setDocIds(Lists.newArrayList(4663, 4664));
//        docReq.setKey("55341");
//
//        portraitService.getOneDocPortrait(docReq);
//
////        ThriftClientProxy proxy = new ThriftClientProxy();
////        proxy.setAppKey("{已申请画像标签权限的appkey}");
////        proxy.setRemoteAppkey("com.sankuai.profile.upsservice");
////        proxy.setRemoteServerPort(9001);
////        proxy.setServiceInterface(Class.forName("com.sankuai.meituan.waimai.d.profile.ups.service.PortraitService"));
////        proxy.setTimeout(2000);
////        proxy.afterPropertiesSet();  //初始化实例
////
////        PortraitService portraitService = (PortraitService) proxy.getObject(); //获取代理对象
////
////        PortraitOneReq req = new PortraitOneReq();
////        req.setDimId(2); // 维度：1->用户；2->商户；
////        req.setKey("xxx"); // 用户ID、商户ID
////        req.setIsEnglishLabelName(true);
////        PortraitOneResp resp = portraitService.getOnePortrait(req); // 单个查询
//    }
//}
