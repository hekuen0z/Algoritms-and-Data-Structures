package week2;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if(n < 1) return 0;

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for(int i = 2; i < n + 1; i++){
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            fibArray[i] %= 10;
        }

        return fibArray[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

