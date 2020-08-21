package task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String a = "acbbca";
        System.out.println("length=" + lengthOfLongestSubstring(a));
    }

    static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    static int findMaxSubString(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        if (s.length() == 1) return 1;

        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;
        HashMap<Character, Integer> elements = new HashMap<>();

        do {
            char c = s.charAt(end);
            if (!elements.containsKey(c)) {
                count++;
            } else {
                max = Math.max(max, count);
                int repeatIndex = elements.get(c);
                int removeCount = repeatIndex - start;
                start = repeatIndex + 1;
                count -= removeCount;
            }
            System.out.println("count =" + count);
            elements.put(c, end);
            end++;
        } while (end < s.length());

        max = Math.max(max, count);

        return max;
    }
}
