import java.io.*;
public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcded";
        String str2 = "aced";
        int l1 = str1.length();
        int l2 = str2.length();
        byUsingTabular(str1,str2,l1,l2);
    }

    private static void byUsingTabular(String a, String b, int x, int y) {
        int dp[][] = new int[x + 1][y + 1];
        for (int i = 0; i <= x ; i++) {
            for (int j = 0; j <= y ; j++) {
                 if(i ==0 || j ==0){
                   dp[i][j] = 0;
                 }
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
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
