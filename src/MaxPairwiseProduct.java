import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {
        int maxFirst = -1, maxSecond = -2, previousIndex = 0;
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            if(maxFirst < numbers[i]) {
                maxFirst = numbers[i];
                previousIndex = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if(maxSecond < numbers[i] && previousIndex != i) {
                maxSecond = numbers[i];
            }
        }

        BigInteger ads = new BigInteger(String.valueOf(maxFirst));
        return ads.multiply(BigInteger.valueOf(maxSecond));
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
