import java.util.Arrays;
import java.util.Scanner;

public class LongestCommomSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str1 = sc.next();
        //System.out.println(byUsingRecursion(str,str1,str.length(),str1.length()));

        //System.out.println(byUsingMemorization(str,str1,str.length(),str1.length()));
        System.out.println(byUsingTabular(str,str1,str.length(),str1.length()));
    }
    private static int byUsingRecursion(String a, String b , int x,int y){
        if(x == 0 || y == 0){
            return 0;
        }
        if(a.charAt(x - 1) == b.charAt(y - 1)){
            return byUsingRecursion(a,b,x-1,y-1) + 1;
        }
        else{
           return Math.max(byUsingRecursion(a,b,x-1,y),byUsingRecursion(a,b,x,y-1));
        }
    }
    private static int byUsingMemorization(String a, String b , int x,int y){
        int dp[][] = new int[x+1][y+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }//aggtab
       // gxtxayb
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        if(x == 0 || y == 0){
            return 0;
        }
        if(a.charAt(x - 1) == b.charAt(y - 1)){
            dp[x][y] = byUsingMemorization(a,b,x-1,y-1) +1;
            return dp[x][y];
        }
        else{
            dp[x][y] = Math.max(byUsingMemorization(a,b,x-1,y),byUsingMemorization(a,b,x,y-1));
            return dp[x][y];
        }
    }
    private static int byUsingTabular(String a, String b , int x,int y){
        int dp [][] = new int[x+1][y+1];
        for(int i = 1; i< x+1;i++){
            for(int j =1; j < y+1; j++){

                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                   // dp[i][j] = 0;
                }
            }
        }
        return dp[x][y];
    }
}
