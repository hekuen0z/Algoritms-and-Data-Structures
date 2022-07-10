package week2;

import java.util.*;

public class FibonacciSumSquares {
    private static int getFibonacciSumSquaresNaive(int n) {
        if(n < 1) return 0;

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for(int i = 2; i < n + 1; i++){
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            fibArray[i] %= 10;
        }

        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            sum += ((fibArray[i] * fibArray[i]) % 10);
            if(sum > 10) {
                sum %= 10;
            }
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

