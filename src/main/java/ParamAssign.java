import java.util.HashSet;

public class ParamAssign {

    public static void main(String[] args) {
        HashSet<String> h = new HashSet<>();
        h.add("1");
        ParamAssign.changeParam(h);
        System.out.println("Set size:" + h.size());
    }

    private static void changeParam(HashSet<String> h) {

        h = new HashSet<>();
        h.add("2");
        System.out.println();
    }
}
