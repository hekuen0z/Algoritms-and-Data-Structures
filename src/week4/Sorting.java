
import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

        private static void randomizedQuickSort(List<Integer> array) {
            Collections.sort(array);
        }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        List<Integer> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            array.add(i, scanner.nextInt());
        }
        randomizedQuickSort(array);
        for (int i = 0; i < n; i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

