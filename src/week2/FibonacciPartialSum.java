package week2;

import java.util.*;

public class FibonacciPartialSum {
    private static int getFibonacciPartialSum(int n, int m) {
        if(n < 1) return 0;

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for(int i = 2; i < n + 1; i++){
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            fibArray[i] %= 10;
        }

        int sum = 0;
        for (int i = m; i < n + 1; i++) {
            sum += fibArray[i];
            if(sum > 10) {
                sum %= 10;
            }
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = getFibonacciPartialSum(n, m);
        if(result > 10) result %= 10;
        System.out.println(result);
    }
}

