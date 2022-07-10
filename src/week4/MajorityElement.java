
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(List<Integer> a) {
        if(a.size() <= 1){
            return 1;
        }

        Collections.sort(a);
        int currentMajority = 1;
        int tempMajority = 1;
        int index = 0;
        for (int i = 1; i < a.size(); i++) {
            if(a.get(i) == a.get(i - 1)) {
                tempMajority++;
            } else if(tempMajority > currentMajority) {
                currentMajority = tempMajority;
                index = i;
                tempMajority = 1;
            }
        }
        if(currentMajority > (a.size() / 2)) return index;
        else return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(i, scanner.nextInt());
        }
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

