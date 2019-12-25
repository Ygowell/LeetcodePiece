package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class StringValid {

    Map<Character, Integer> map = new HashMap<>();

    public StringValid() {
        map.put('(', 0);
        map.put(')', 1);
        map.put('{', 2);
        map.put('}', 3);
        map.put('[', 4);
        map.put(']', 5);
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = map.get(c);

            if (index % 2 == 1) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    int topIndex = map.get(top);
                    if (topIndex != index - 1) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
