package week5;

import java.util.*;

public class LCS2 {

    private static int[][] lcs2(int[] a, int[] b) {
        int n = a.length + 1;
        int m = b.length + 1;

        int[][] distanceArray = new int[n][m];

        for (int i = 1; i < n; i++) {
            if(a[i - 1] == b[0]) {
                distanceArray[i][0] = 1;
            } else {
                distanceArray[i][0] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            if(b[i - 1] == a[0]) {
                distanceArray[0][i] = 1;
            } else {
                distanceArray[0][i] = 0;
            }
        }

        for(int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                int prevColumnNum = distanceArray[i][j - 1];
                int prevLineNum = distanceArray[i - 1][j];
                int mismatch = distanceArray[i - 1][j - 1];
                int match = distanceArray[i - 1][j - 1] + 1;
                if(a[i - 1] == b[j - 1]){
                    distanceArray[i][j] = Math.max(match, Math.max(prevColumnNum, prevLineNum));
                } else
                    distanceArray[i][j] = Math.max(mismatch, Math.max(prevColumnNum, prevLineNum));
            }
        }
        return distanceArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        int[][] resultMatrix = lcs2(a, b);
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        //System.out.println(lcs2(a, b));
    }
}

