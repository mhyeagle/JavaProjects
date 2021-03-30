package meituanProj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class HighLevelDimExport {
    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader("/Users/miaohongyuan/tmp/2020_high_level_dims.csv");
        FileReader fileReader = new FileReader("/Users/miaohongyuan/tmp/2020_poi.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String doc = bufferedReader.readLine();
        while (StringUtils.isNotEmpty(doc)) {
            String[] docInfo = doc.split("\t");
//            System.out.print("docId:" + docInfo[0] + "\t");
//            JSONObject conf = JSON.parseObject(docInfo[1]);
//            printHighLevelKey(conf);

            JSONArray conf = JSON.parseArray(docInfo[1]);
            printOldFormatKey(conf);
//            System.out.print("\n");
            doc = bufferedReader.readLine();
        }

//        String line = "{\"children\":[{\"children\":[{\"children\":[{\"children\":[{\"children\":[{\"children\":[],\"expr\":[{\"id\":19,\"key\":\"end_order_source\",\"value\":[1,2]},{\"id\":32,\"key\":\"end_city_type\",\"value\":[1]}],\"type\":\"and\"}],\"expr\":[{\"id\":26,\"key\":\"end_aor_type\",\"value\":[2]}],\"type\":\"and\"}],\"expr\":[{\"id\":36,\"key\":\"end_usr_city_id\",\"value\":[\"110100\",\"440100\",\"310100\",\"440300\",\"120100\",\"440600\",\"420100\",\"330100\",\"510100\",\"350100\",\"350200\",\"441900\",\"320100\",\"320500\",\"210100\",\"210200\",\"610100\",\"350500\",\"440500\",\"441300\",\"370100\",\"330200\",\"131000\",\"330300\",\"130100\",\"140100\",\"330700\",\"320200\",\"440700\",\"330400\",\"130600\",\"350600\",\"321000\",\"320300\",\"331000\",\"320400\",\"330600\",\"441800\",\"330500\",\"441200\",\"441500\",\"130300\",\"350300\",\"320600\",\"440900\",\"441600\",\"370300\",\"440800\",\"441700\",\"441400\",\"130900\",\"420500\",\"320900\",\"420600\",\"321300\",\"350400\",\"510700\",\"510500\",\"445200\",\"321100\",\"130200\",\"321200\",\"350700\",\"350800\",\"210800\",\"130500\",\"440200\",\"330800\",\"350900\",\"421000\",\"320800\",\"140200\",\"210300\",\"130700\",\"140800\",\"445300\",\"420900\",\"420300\",\"511300\",\"320700\",\"140700\",\"420200\",\"371700\",\"210400\",\"370500\",\"510600\",\"210600\",\"330900\",\"140400\",\"610800\",\"421200\",\"370900\",\"421300\",\"211100\",\"510400\",\"141100\",\"141000\",\"371500\",\"331100\",\"511100\",\"420800\",\"140500\",\"210700\",\"370800\",\"421100\",\"610700\",\"130400\",\"510800\",\"511700\",\"130800\",\"371600\",\"510300\",\"512000\",\"511500\",\"140300\",\"610600\",\"140900\",\"610400\",\"4290041\",\"510900\",\"140600\",\"4290051\",\"511400\",\"211000\",\"211400\",\"131100\",\"210900\",\"420700\",\"371400\",\"445100\",\"211300\",\"210500\",\"610300\",\"511900\",\"610900\"]}],\"type\":\"and\"}],\"expr\":[{\"id\":166,\"key\":\"avg_pay_amt\",\"min\":\"30\"}],\"type\":\"and\"}],\"expr\":[{\"id\":70,\"key\":\"alphau2_flag\",\"value\":[1,2,3]}],\"type\":\"and\"}],\"expr\":[{\"id\":116,\"key\":\"label_r\",\"value\":[3]}],\"type\":\"and\"}";
//        JSONObject conf = JSON.parseObject(line);
//
//        printHighLevelKey(conf);
    }

    private static void printHighLevelKey(JSONObject conf) {
        JSONArray exprArr = conf.getJSONArray("expr");
        for (int i = 0; i < exprArr.size(); i++) {
            JSONObject expr = (JSONObject) conf.getJSONArray("expr").get(i);
            JSONArray values = expr.getJSONArray("value");

//            function1：多值查询
//            if (null != values && values.size() > 100) {
//                System.out.print(expr.get("key"));
//                System.out.print("\t" + values.size() + "\n");
//            }

            // function2：过滤key
            System.out.println(expr.get("key"));
        }

        JSONArray children = conf.getJSONArray("children");
        if (null != children && children.size() > 0) {
            printHighLevelKey((JSONObject) children.get(0));
        }
    }

    private static void printOldFormatKey(JSONArray conf) {

        for (int i = 0; i < conf.size(); i++) {
            JSONObject expr = (JSONObject) conf.get(i);
            System.out.println(expr.get("feature_field"));
        }
    }
}
