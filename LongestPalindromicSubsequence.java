public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str1 = "abkccbc";
        StringBuffer str2 = new StringBuffer(str1);
        str2.reverse();
        int n = str1.length();
        int m = str2.length();
        //System.out.println(str2);
        System.out.println(byUsingTabular(str1, String.valueOf(str2),n,m));
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

                }
            }
        }
        return dp[x][y];
    }
}
