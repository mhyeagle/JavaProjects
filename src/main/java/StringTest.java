import java.util.LinkedList;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        String sourceWord = "麻辣诱惑";
        String whiteList = "麻辣诱惑,乡村基";
        String[] whitesWords = whiteList.split(",");

        splitWords(sourceWord, whitesWords);

        String str = "a     b,c\t\n";
        String strReplace = str.replaceAll("[\\s,]", "");
        System.out.println("str result:" + strReplace);

        String blankStr = " a bc ";
        System.out.println("-" + blankStr + "-");
        System.out.println("trim-" + blankStr.trim() + "-");
    }

    private static List<String> splitWords(String word, String[] whites) {
        LinkedList<String> result = new LinkedList<>();
        result.add(word);

        System.out.println("切词前：" + word);

        for (String white : whites) {
            for (int i = 0; i < result.size(); i++) {
                String tmpStr = result.get(i);
                if (tmpStr.contains(white)) {
                    String[] keys = tmpStr.split(white);
                    if (keys.length == 0) {
                        result.remove(i);
                        i--;
                    }

                    for (int j = 1; j < keys.length; j++) {
                        result.add(keys[j]);
                    }
                    if (keys.length > 0) {
                        result.set(i, keys[0]);
                    }
                }
            }
        }

        System.out.println("根据白名单切词后 result:" + result.toString());

        return result;
    }
}
