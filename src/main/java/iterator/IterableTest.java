package iterator;

import java.io.IOException;

public class IterableTest {
    public static void main(String[] args) throws IOException {
        FileReadObj obj = new FileReadObj("/Users/miaohongyuan/tmp/test.txt");
        while (obj.hasNext()) {
            String line = obj.next();
            System.out.println(line);
        }
    }

}
