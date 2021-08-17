package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring_20200830(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int L=0,R=0;
        int max_len=1;
        int start=0,end=0;
        for(;R<s.length();R++){
            char c=s.charAt(R);
            if(map.containsKey(c)){
                L=Math.max(L, map.get(c)+1);
            }
            map.put(c, R);
            if(max_len<R-L+1){
                max_len=R-L+1;
                start=L;
                end=R;
            }
        }
        System.out.print(s.substring(start,end+1));
        return max_len;
    }
}
