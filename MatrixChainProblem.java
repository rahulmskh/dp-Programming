public class MatrixChainProblem {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int n = arr.length;
        System.out.println(matrixChainOrder(arr,1,n-1));
    }
    public static int matrixChainOrder(int [] arr, int i, int j){
        if(i == j){
            return 0;
        }
        int count ;
        int min = Integer.MAX_VALUE;
        for(int k =i; k<j ; k++){
            count = matrixChainOrder(arr,i,k)+matrixChainOrder(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
            if(count < min )
                min = count;
        }
        return min;
    }
}
