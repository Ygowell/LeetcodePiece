package array;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class WordAnagram {

    public static void main(String[] args) {
        String s = "asdfgzzzd";
        String t = "zfgdsazza";

        System.out.println(s + "," + t + ": " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] words = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int sIndex = Integer.valueOf(s.charAt(i) - 'a');
            System.out.println("sIndex = " + sIndex);
            words[sIndex] = words[sIndex] + 1;
            int tIndex = Integer.valueOf(t.charAt(i) - 'a');
            words[tIndex] = words[tIndex] - 1;
        }

        for (int i = 0; i < 26; i++) {
            if (words[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
