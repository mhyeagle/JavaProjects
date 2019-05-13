import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        String prefix = "prefix_";

        List<String> keys = new ArrayList<>(Arrays.asList("xa", "yb", "zc"));

        Map<String, String> result = keys
                .stream()
                .collect(Collectors.toMap(String::toString, key->prefix+key));

        System.out.println(result);
    }
}
