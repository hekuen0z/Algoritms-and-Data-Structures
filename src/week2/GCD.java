package week2;

import java.util.*;

public class GCD {
    private static int computeGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return computeGCD(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(computeGCD(a, b));
    }
}
