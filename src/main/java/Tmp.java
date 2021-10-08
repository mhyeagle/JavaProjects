import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Tmp {
    public static void main(String[] args) {
        double a = 0.0153;
        System.out.println(percentFormat(a));

        ClassA classA = new ClassA();
        System.out.println("classA: " + classA.toString());

        List<ClassA> classAList = new ArrayList<>();
        classAList.add(new ClassA());
        classAList.add(new ClassA(1, 2L, "world"));

        System.out.println("List<ClassA>: " + classAList.toString());

        List<String> list = null;
        for (String str : list) {
            System.out.println("list is null");
        }
    }

    public static String percentFormat(double value) {
        return value * 100 + "%";
    }

    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClassA {
        private Integer v1 = 0;
        private Long v2 = 1L;
        private String v3 = "hello";
    }
}
