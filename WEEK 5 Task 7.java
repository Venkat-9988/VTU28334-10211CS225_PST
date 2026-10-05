class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (last[ch] > left) {
                left = last[ch];
            }

            last[ch] = right + 1;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
