import java.util.Scanner;

public class UnboundedKnapSack {
    public static void main(String[] args) {
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
        System.out.println(maxProfit(wt, val, cap));
       // System.out.println(maxValue(wt, val, cap));

    }
    private static int maxProfit(int[] wt,int[] val,int cap){
        int dp[] = new int[cap + 1];
       dp[0] = 0;
       for(int col = 1; col<dp.length;col++){
           int max = 0;
           for(int wtIdx = 0; wtIdx< wt.length;wtIdx++){

               if(wt[wtIdx] <= col){
                   int remWt = col - wt[wtIdx];
                   int remWtVAl = dp[remWt];
                   if(remWtVAl + val[wtIdx] > max){
                       max = remWtVAl + val[wtIdx];
                   }
               }
           }
           dp[col] = max;
       }
       return dp[cap];

//        private static int maxValue(int[] weights, int[] value, int capacity) {
//
//            int[] dp = new int[capacity + 1];
//            dp[0] = 0;
//
//            for (int col = 1; col < dp.length; col++) {
//                int max = 0;
//                for (int wtIndex = 0; wtIndex < weights.length; wtIndex++) {
//
//                    if (weights[wtIndex] <= col) {
//                        int remWt = col - weights[wtIndex];
//                        int remWtVal = dp[remWt];
//                        if (remWtVal + value[wtIndex] > max)
//                            max = remWtVal + value[wtIndex];
//                    }
//
//                }
//                dp[col] = max;
//            }
//            return dp[capacity];
    }
}
