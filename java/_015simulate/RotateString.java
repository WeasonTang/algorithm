package _015simulate;

/**
 * #796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * 
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 */
public class RotateString {

    public static void main(String[] args) {
        String s1 = "abcde", goal1 = "cdeab";
        System.out.println(rotateString(s1, goal1)); // true

        String s2 = "abcde", goal2 = "abced";
        System.out.println(rotateString(s2, goal2)); // false
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }    
        return false;
    }
}
