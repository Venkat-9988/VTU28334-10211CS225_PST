import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        char[] map = new char[26];
        char[] reverse = new char[26];

        for (int i = 0; i < pattern.length(); i++) {
            int p = pattern.charAt(i) - 'a';
            int w = word.charAt(i) - 'a';

            // Pattern character already mapped
            if (map[p] != 0 && map[p] != word.charAt(i)) {
                return false;
            }

            // Word character already mapped to another pattern character
            if (reverse[w] != 0 && reverse[w] != pattern.charAt(i)) {
                return false;
            }

            map[p] = word.charAt(i);
            reverse[w] = pattern.charAt(i);
        }

        return true;
    }
}
