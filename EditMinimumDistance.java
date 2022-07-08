import java.util.Scanner;

public class EditMinimumDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int n1 = str1.length();
        int n2 = str2.length();
        System.out.println(editMinDistance(str1,str2,n1,n2));
        //Time Complexity: O(m x n)
        //Auxiliary Space: O(m x n)
    }

    private static int editMinDistance(String a, String b, int x, int y) {
        int dp[][] = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                if(i == 0 ){
                    dp[i][j] = j;
                }
                else if( j == 0){
                    dp[i][j] = i;
                }
                else{
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        int f1 = 1 + dp[i-1][j-1];//replace
                        int f2 = 1 + dp[i-1][j];//delete;
                        int f3 = 1 + dp[i][j-1];//insert
                        dp[i][j] = Math.min(f1,Math.min(f2,f3));
                    }
                }

            }
        }
        return dp[x][y];
    }
}
