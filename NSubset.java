import java.util.Scanner;

public class NSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(hasSubset(arr, s));
    }
    private static boolean hasSubset(int arr[] ,int sum){
        boolean dp[][] = new boolean[arr.length+1][sum+1];

        for(int i = 0 ; i < dp.length;i++){
            for(int j =0; j<dp[0].length; j++){

                if(i == 0 && j ==0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] =false;
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                else{
                    // not considering the current element
                    if(dp[i-1][j])
                        dp[i][j] = dp[i-1][j];
                    else{
                        // considering the current element as well
                        if(j >= arr[i-1]){
                            int remSum = j - arr[i-1];
                            dp[i][j] = dp[i-1][remSum];
                        }
                        else{
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }

}
