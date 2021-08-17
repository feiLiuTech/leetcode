package WrittenExamination;

import java.util.Scanner;
//I need book.;I need book 2.
//This is a book.;this is a book.(0,5)
//This is book.;this is a book. (1,5)
//this is a good book.;This is a book. (1,5)
//this is a duck.;this is a book. (2,5)
//this is a boOk.; this is a book.(0,5) //注意前面的空格
public class DifferString {
    public static void min_differ(String [] s1, String [] s2){
        int n=s1.length;
        int m=s2.length;
        int [][] dp=new int[n+1][m+1];
        //一个空串与另一个长度为n的串的偏差是n
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1].equalsIgnoreCase(s2[j-1])){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1], dp[i-1][j])+1,dp[i-1][j-1]+2);
                }
            }
        }
        System.out.println("("+dp[n][m]+","+s2.length+")");
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String [] arr=str.split(";");
        String source=arr[0].trim();
        String target=arr[1].trim();
        String [] s1=process(source).split(" ");
        String [] s2=process(target).split(" ");
        min_differ(s1,s2);
    }
    public static String process(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(i!=0 &&(c=='.'|| c=='!'|| c==',') ){
                sb.append(" ").append(".");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

 class DifferString20200918 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String [] arr=str.split(";");
        String source=arr[0].trim();
        String target=arr[1].trim();
        String [] s1=process(source).split(" ");
        String [] s2=process(source).split(" ");
        min_differ(s1,s2);

    }
    public static void min_differ(String [] s1, String [] s2){
        int n=s1.length;
        int m=s2.length;
        int [][] dp=new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(s1[i-1].equalsIgnoreCase(s2[j-1])){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+2);
                }
            }
        }
        System.out.println("("+dp[n][m]+","+s2.length+")");


    }


    public static String process(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(i!=0 && c=='.' || c==',' || c=='!'){
                sb.append(" ").append(".");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}