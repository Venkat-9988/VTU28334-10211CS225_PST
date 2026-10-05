import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();

            int[] left = new int[26];
            int[] right = new int[26];

            // Count characters in the first half
            for (int i = 0; i < n / 2; i++) {
                left[s.charAt(i) - 'a']++;
            }

            // Count characters in the second half
            // Middle character is skipped automatically for odd length
            for (int i = (n + 1) / 2; i < n; i++) {
                right[s.charAt(i) - 'a']++;
            }

            boolean isLapindrome = true;

            // Compare frequencies
            for (int i = 0; i < 26; i++) {
                if (left[i] != right[i]) {
                    isLapindrome = false;
                    break;
                }
            }

            if (isLapindrome) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
