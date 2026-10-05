import java.util.*;

public class Main {

    static int migratoryBirds(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int bird : arr) {
            map.put(bird, map.getOrDefault(bird, 0) + 1);
        }

        int maxCount = 0;
        int answer = Integer.MAX_VALUE;

        // Find most frequent and smallest ID
        for (int bird : map.keySet()) {
            int count = map.get(bird);

            if (count > maxCount) {
                maxCount = count;
                answer = bird;
            } else if (count == maxCount && bird < answer) {
                answer = bird;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(migratoryBirds(arr));
    }
}
