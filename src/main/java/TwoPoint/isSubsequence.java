package TwoPoint;

public class isSubsequence {
    public static void main(String[] args) {
        isSubsequence.isSubsequence("axc","ahbgdc");
    }
    public static boolean isSubsequence(String s, String t) {

        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i==s.length()?true:false;
    }
}
