import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ForEachTest {
    public class DocType {
        private List<String> exprs;

        DocType(List<String> exprs) {
            this.exprs = exprs;
        }

        public void traver() {
            for (String s : this.exprs) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
//        DocType docType = new DocType(list);
    }
}
