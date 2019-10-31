import javax.security.sasl.SaslServer;
import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader;
        // resources目录下test.txt文件
        fileReader = new FileReader("/Users/miaohongyuan/Desktop/test.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String lineStr = null;

        Pattern p = Pattern.compile("key\":\"[a-z0-9_]+\"");

        HashMap<String, HashSet<String>> cache = new HashMap<>();
        while (null != (lineStr = br.readLine())) {
            HashSet<String> fields = null;
            String[] words = lineStr.split("\t");
            String nameEnCn = words[0] + "\t" + words[1];
            if (!cache.containsKey(nameEnCn)) {
                fields = new HashSet<>();
                cache.put(nameEnCn, fields);
            }
            fields = cache.get(nameEnCn);

            Matcher m = p.matcher(words[2]);
            while (m.find()) {
                String originLine = m.group();
                String[] arr = originLine.split("\"");
                if (arr.length != 3) {
                    System.out.print("data error: " + originLine);
                }
                fields.add(arr[2]);
            }
        }

        for (Map.Entry<String, HashSet<String>> entry : cache.entrySet()) {
            if (entry.getValue().size() != 0) {
                System.out.print(entry.getKey() + "\t");

                Iterator iterator = entry.getValue().iterator();
                System.out.print(iterator.next());
                while (iterator.hasNext()) {
                    System.out.print(",");
                    System.out.print(iterator.next());
                }
                System.out.println();
            }
        }
    }
}
