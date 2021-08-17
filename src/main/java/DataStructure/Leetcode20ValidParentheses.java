package DataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 示例 1:
 输入: "()"
 输出: true
 */
public class Leetcode20ValidParentheses {
    public boolean isValid_2020_0831(String s) {
        if(s==null){
            return true;
        }
        Map<Character,Character> map=new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack=new Stack<Character>();
        for(Character c: s.toCharArray()){
            if(map.containsKey(c)){
                //说明是左括号
                stack.add(c);
            }else{
                char ch=stack.isEmpty()?'#':map.get(stack.pop());
                if(ch!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
