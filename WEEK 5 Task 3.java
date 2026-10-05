import java.util.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int current = arr.get(0);
        int maxSubarray = arr.get(0);

        int maxSubsequence = arr.get(0);

        // Maximum subarray - Kadane's Algorithm
        for (int i = 1; i < arr.size(); i++) {
            current = Math.max(arr.get(i), current + arr.get(i));
            maxSubarray = Math.max(maxSubarray, current);
        }

        // Maximum subsequence
        int positiveSum = 0;
        int largest = arr.get(0);

        for (int x : arr) {
            if (x > 0) {
                positiveSum += x;
            }

            largest = Math.max(largest, x);
        }

        if (positiveSum > 0) {
            maxSubsequence = positiveSum;
        } else {
            maxSubsequence = largest;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> result = maxSubarray(arr);

            System.out.println(result.get(0) + " " + result.get(1));
        }

        sc.close();
    }
}
