import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w, int[] v) {
        int n = W + 1;
        int m = w.length + 1;
        int[][] value = new int[n][m];
        for(int i = 0; i < n; i++) {
            value[i][0] = 0;
        }
        for (int i = 0; i < m; i++) {
            value[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                value[j][i] = value[j][i - 1];
                if(w[i - 1] <= j) {
                    int val = value[j - w[i - 1]][i - 1] + v[i - 1];
                    if(value[j][i] < val) {
                        value[j][i] = val;
                    }
                }
            }
        }

        return value[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int[] v = w;
        System.out.println(optimalWeight(W, w, v));
    }
}

