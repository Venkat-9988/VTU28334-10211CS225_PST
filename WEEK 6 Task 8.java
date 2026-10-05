import java.util.*;

public class Solution {

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String haystack = sc.nextLine();
        String needle = sc.nextLine();

        int result = strStr(haystack, needle);

        System.out.println(result);

        sc.close();
    }
}
