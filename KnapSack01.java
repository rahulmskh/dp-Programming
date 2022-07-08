import org.omg.Messaging.SyncScopeHelper;

import java.util.Scanner;

public class KnapSack01 {
    public static void main(String[] args) {

          //KnapSack Using resursion
//     int wt[] = {10, 20, 30 };
//     int val[] = { 60, 100, 120 };
//     int w = 50;
//        int n = val.length;
//        System.out.println(maxProfit(wt,val,n,w));
//    }
//     public static int maxProfit(int wt[], int val[], int n,int w){
//        if(n == 0 || w == 0 ){
//            return 0;
//        }
//        if(wt[n-1] <= w)
//            return Math.max(val[n-1] + maxProfit(wt,val,n-1,w-wt[n-1]), maxProfit(wt,val,n-1,w));
//
//        else
//            return (maxProfit(wt,val,n-1,w));
//     }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wt [] = new int[n];
        int val[] = new int[n];

        for (int i = 0; i<wt.length; i++){
            wt[i] = sc.nextInt();
        }
        for(int i = 0 ; i<val.length;i++){
            val[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        int dp[][] = new int[n+1][cap+1];
        for(int i = 1;i< dp.length;i++){
            for(int j = 1;j<dp[0].length; j++){
                if(j >= wt[i -1]){
                    int remCap = j -wt[i -1];
                    if(dp[i-1][remCap] + val[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][remCap] + val[i-1];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
         System.out.println(dp[n][cap]);

//        int[] weights = {2, 5, 3, 1, 6};
//        int[] value = {25, 18, 5, 10, 20};
//
//        int capacity = 6;
//        System.out.println(maxValue(weights,value,capacity));
//    }
//
//    private static int maxValue(int[] weights, int[] value, int capacity) {
//
//        int[][] dp = new int[weights.length + 1][capacity + 1];
//
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j < dp[0].length; j++) {
//
//                if (j >= weights[i - 1]) {
//                    int wtVal = value[i - 1];
//                    int remWt = j - weights[i - 1];
//                    int remWtVal = dp[i - 1][remWt];
//                    if (wtVal + remWtVal > dp[i - 1][j])
//                        dp[i][j] = wtVal + remWtVal;
//                    else
//                        dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[weights.length][capacity];
    }


}
