import java.util.Scanner;

public class CountMaxWayOfPathInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
      //  System.out.println(countMaxPath(n,m));
       // System.out.println(countMaxPath2(n,m));
        System.out.print(countMaxPath3(n,m));
    }
    //Tabulation
    private static int countMaxPath(int n, int m){
        int dp[][] = new int[n][m];
       for(int i = 0 ; i<n; i++){
          dp[i][0] = 1;
       }
        for(int  j= 0 ;j< m; j++){
           dp[0][j] = 1;
        }
//        if(n == 1 || m == 1){
//            dp[n][m] = 1;
//        }
        for(int i = 1; i< n ; i++){
            for(int j = 1; j< m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    // Recursion
    private static int countMaxPath2(int n, int m){
        if(n == 1 || m == 1){
            return 1;
       }
        return countMaxPath2(n-1,m) + countMaxPath2(n,m-1);
    }
    //Memorization
    private static int countMaxPath3(int n, int m){
        int dp [][] = new int[n+1][m+1];
        if( n == 1 || m == 1){
            dp[n][m] = 1;
        }
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m; j++){
                dp[i][j] = 0;
            }
        }
        if (dp[n][m] == 0){
            dp[n][m] = countMaxPath3(n-1,m) + countMaxPath3(n,m-1);
        }
        return dp[n][m];
    }
}
