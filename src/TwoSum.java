import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        if (sum < 1 || list.length < 2) return null;
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < list.length; i++) {
            int remain = sum - list[i];
            if (m.containsKey(remain)) {
                return new int[] {i, m.get(remain)};
            } else {
                m.put(remain, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
