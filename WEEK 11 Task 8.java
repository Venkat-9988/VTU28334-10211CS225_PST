import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                System.out.println("[" + map.get(needed) + ", " + i + "]");
                return;
            }

            map.put(nums[i], i);
        }
    }
}
