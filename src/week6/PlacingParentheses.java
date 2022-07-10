package week6;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = exp.length();
        StringBuffer source = new StringBuffer(exp);
        StringBuffer op = new StringBuffer(exp.length() / 2);
        for (int i = 1; i < exp.length(); i += 2) {
            op.append(source.charAt(i));
        }

        int m = n / 2 + 1;
        int[][] minArray = new int[m][m];
        int[][] maxArray = new int[m][m];
        int[] digits = new int[m];
        for (int i = 0, j = 0; i < m; i++, j += 2) {
            digits[i] = source.charAt(j) - '0';
        }

        for (int i = 0; i < m; i++) {
            minArray[i][i] = digits[i];
            maxArray[i][i] = digits[i];
        }

        for (int s = 1; s < m; s++) {
            for (int i = 0; i < m - s; i++) {
                int j = i + s;
                String[] result = MinAndMax(minArray, maxArray, i, j, op).split(" ");
                minArray[i][j] = Integer.parseInt(result[0]);
                maxArray[i][j] = Integer.parseInt(result[1]);
            }
        }

        printArray(minArray, m);
        printArray(maxArray, m);

        return maxArray[0][m - 1];
    }

    private static void printArray(int[][] sourceArray, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(sourceArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static String MinAndMax(int[][] minArray, int[][] maxArray, int i, int j, StringBuffer op) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int a = 0, b = 0, c = 0, d = 0;
        for (int k = i; k < j; k++) {
            switch (op.charAt(k)) {
                case '+':
                    a = maxArray[i][k] + maxArray[k + 1][j];
                    b = maxArray[i][k] + minArray[k + 1][j];
                    c = minArray[i][k] + maxArray[k + 1][j];
                    d = minArray[i][k] + minArray[k + 1][j];
                    break;
                case '-':
                    a = maxArray[i][k] - maxArray[k + 1][j];
                    b = maxArray[i][k] - minArray[k + 1][j];
                    c = minArray[i][k] - maxArray[k + 1][j];
                    d = minArray[i][k] - minArray[k + 1][j];
                    break;
                case '*':
                    a = maxArray[i][k] * maxArray[k + 1][j];
                    b = maxArray[i][k] * minArray[k + 1][j];
                    c = minArray[i][k] * maxArray[k + 1][j];
                    d = minArray[i][k] * minArray[k + 1][j];
                    break;
            }
            min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
            max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
        }
        String result = min + " " + max;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

