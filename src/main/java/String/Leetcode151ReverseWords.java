package String;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "  hello world!  "
 输出: "world! hello"
 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 */
public class Leetcode151ReverseWords {
    public static void main(String[] args) {
        Leetcode151ReverseWords20200831 test=new Leetcode151ReverseWords20200831();
        test.reverseWords("the sky is blue");
    }

    /**解法一：分割+倒序
     * 注意：split函数切分字符串后，中间的空格如果多于一个，那么会产生多余的空字符，注意不是空格
     * @param s
     * @return
     */
    public String reverseWords_1_2020_0830(String s) {
        s=s.trim();
        String [] word=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            if(word[i].equals("")){
                continue;
            }
            sb.append(word[i]+" ");
        }
        return sb.toString().trim();
    }


}
class Leetcode151ReverseWords20200831{


    /**
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        s=s.trim();
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1,j=s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }
            //走到第一个非空格
            sb.append(s.substring(i+1,j+1)+" ");
            //跳过空格
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            //到达第一个非空格
            j=i;

        }
        return sb.toString().trim();
    }


}