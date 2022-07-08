import java.util.Scanner;

public class NCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
       // System.out.println(nCoinsCombinations(arr,tar));
        System.out.println(nCoinsPermutations(arr,tar));
    }
    // To find n number of combinations for a given target and given denominations
    private static int nCoinsCombinations(int[] coins, int tar){
        int dp[] = new int[tar+1];
        dp[0] = 1;
        for(int i = 0; i<coins.length; i++){
            for (int j = 1; j< dp.length;j++){
                if(coins[i] <= j){
                    int rem = j -coins[i];
                    dp[j] += dp[rem];
                }
            }
        }
        return dp[tar];
    }
    // To find n number of permutations for a given target and given denominations
    private static int nCoinsPermutations(int []coins,int tar){
       int dp[] = new int[tar+1];
       dp[0] = 1;
       for (int amt = 1 ; amt <= tar;amt++){
           for(int coin:coins){
               if(coin <= amt){
                   int reAmt = amt - coin;
                   dp[amt] += dp[reAmt];
               }
           }
       }
        return dp[tar];
    }
}


