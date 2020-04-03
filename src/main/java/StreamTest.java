import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        String prefix = "prefix_";

        List<String> keys = new ArrayList<>(Arrays.asList("xa", "yb", "zc"));

        Map<String, String> result = keys
                .stream()
                .collect(Collectors.toMap(String::toString, key->prefix+key));

        System.out.println(result);

        Map<String, String> tmp = new HashMap<>();
        result.entrySet().stream()
                .filter(Objects::nonNull)
                .forEach(
                        s -> {
                            String value = s.getValue();
                            tmp.put(s.getKey(), value);
                            value += "_suffix";
                            s.setValue(value);
                        }
                );

        System.out.println("tmp: " + tmp);
        System.out.println("origin result: " + result);
    }
}
