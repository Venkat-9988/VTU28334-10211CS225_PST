class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;

        // Remove the first and last character
        String temp = doubled.substring(1, doubled.length() - 1);

        return temp.contains(s);
    }
}
