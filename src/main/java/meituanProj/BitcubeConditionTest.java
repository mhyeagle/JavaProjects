//package meituanProj;
//
//import com.alibaba.fastjson.JSON;
//import com.sankuai.waimai.data.bitcube.req.condition.*;
//
//public class BitcubeConditionTest {
//    public static void main(String[] args) {
//        Condition equal_1 = ConditionFactory.eq("gender", 1);
//        System.out.println("equal json: " + JSON.toJSON(equal_1));
//
//        RangeCondition range_1 = ConditionFactory.range("price", 1, 200, false, true);
//        System.out.println("range json: " + JSON.toJSON(range_1));
//
//        InCondition in_1 = ConditionFactory.in("city", 110100, 130100, 140800);
//        System.out.println("in json: " + JSON.toJSON(in_1));
//
//        CompositeNotCondition notConditions = ConditionFactory.not(in_1);
//        System.out.println("composite not condition: " + JSON.toJSON(notConditions));
//
//        CompositeOrCondition orCondition = ConditionFactory.or(equal_1, range_1);
//        System.out.println("composite or condition: " + JSON.toJSON(orCondition));
//
//        CompositeAndCondition andConditions = ConditionFactory.and(equal_1, range_1, notConditions);
//        System.out.println("composite and condition: " + JSON.toJSON(andConditions));
//    }
//}
