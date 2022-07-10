package week6;

import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum == 0 || sum % 3 != 0)
            return 0;

        int m = A.length + 1;
        int n = sum / 3  + 1;
        int[][] tab = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int diff = i - A[j - 1];
                if ((A[j - 1] == i) || (diff > 0 && tab[diff][j - 1] > 0)) {
                    tab[i][j] = (tab[i][j - 1] == 0) ? 1 : 2;
                } else {
                    tab[i][j] = tab[i][j - 1];
                }
            }
        }

/*        System.out.println(sum);
        printArray(tab, n, m);*/

        if (tab[n - 1][m - 1] == 2)
            return 1;
        else
            return 0;
    }

    private static void printArray(int[][] sourceArray, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(sourceArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

