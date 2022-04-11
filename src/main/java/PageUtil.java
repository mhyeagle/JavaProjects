import java.util.LinkedList;
import java.util.List;

public class PageUtil {
    public static <T> List<T> getPage(Integer pageId, Integer pageSize, List<T> data) {
        Integer offset = (pageId - 1) * pageSize;
        if (data.size() <= offset) {
            return null;
        }

        if (offset + pageSize < data.size()) {
            return data.subList(offset, offset + pageSize);
        } else {
            return data.subList(offset, data.size());
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);

        System.out.println(getPage(3, 3, nums));

    }
}
