package task;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class StrArrange {

    public static void main(String[] args) {
        String s1 = "fec";
        String s2 = "abcdef";
        System.out.println("checkInclusion: " + checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        if (s1.length() > s2.length()) return false;

        char[] charArr = s1.toCharArray();

        return isInclusion(charArr, 0, s2);
    }

    private static boolean isInclusion(char[] arr, int start, String s2) {
        if (start == arr.length - 1) {
            String result = String.valueOf(arr);
            System.out.println("result: " + result);
            if (s2.contains(result)) {
                return true;
            }
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            if (isInclusion(arr, start + 1, s2)) {
                return true;
            }
            swap(arr, start, i);
        }

        return false;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
