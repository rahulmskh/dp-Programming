public class PrintLongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str1 = "abkccbc";
        StringBuffer str2 = new StringBuffer(str1);
        str2.reverse();
        int n = str1.length();
        int m = str2.length();
        //System.out.println(str2);
        byUsingTabular(str1, String.valueOf(str2), n, m);
    }
    private static void byUsingTabular(String a, String b , int x,int y){
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
        int idx = dp[x][y];
        int temp = idx;
        char [] lcs = new char[idx+1];
        // byUsingTabular[idx] = '\u0000'; // Set the terminating character
        int i = x;
        int j = y;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                lcs[idx-1] = a.charAt(i-1);
                i--;
                j--;
                idx--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
                i--;

            else
                j--;

        }
        for(int z = 0; z<temp; z++)
            System.out.print(lcs[z]);
    }
}
