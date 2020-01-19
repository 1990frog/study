import org.junit.Test;

import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution20 {
    public boolean isValid(String s) {
        LinkedList<String> list = new LinkedList();
        for(char cur:s.toCharArray())
            list.add(cur+"");
        while (list.size()>0){
            String head = list.removeFirst();
            String tail = list.removeLast();
            boolean flag = head.equals("(") && tail.equals(")")
                    || head.equals("[") && tail.equals("]")
                    || head.equals("{") && tail.equals("}");
            if(!flag)
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        String s = "{[({})]}";
        System.out.println(isValid(s));
    }
}
