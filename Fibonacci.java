import java.util.Scanner;
public class Fibonacci {
    static int n1 = 0;
    static int n2 = 1;
    static int n3 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(n1+" "+n2);
        printFibonacci(n-2);
    }
    private static void printFibonacci(int n){
        if(n > 0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            printFibonacci(n-1);
        }
    }
}
