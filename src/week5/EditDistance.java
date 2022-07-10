package week5;

import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        StringBuffer sBuf = new StringBuffer(s);
        StringBuffer tBuf = new StringBuffer(t);
        int n = sBuf.length() + 1;
        int m = tBuf.length() + 1;

        int[][] distanceArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            distanceArray[i][0] = i;
        }
        for (int i = 0; i < m; i++) {
            distanceArray[0][i] = i;
        }

        for(int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                int insertion = distanceArray[i][j - 1] + 1;
                int deletion = distanceArray[i - 1][j] + 1;
                int mismatch = distanceArray[i - 1][j - 1] + 1;
                int match = distanceArray[i - 1][j - 1];
                if(sBuf.charAt(i - 1) == tBuf.charAt(j - 1)){
                    distanceArray[i][j] = Math.min(match, Math.min(insertion, deletion));
                } else
                    distanceArray[i][j] = Math.min(mismatch, Math.min(insertion, deletion));
            }
        }
        return distanceArray[n - 1][m - 1];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));

//        int[][] resultMatrix = EditDistance(s, t);
//
//        for (int i = 0; i < s.length() + 1; i++) {
//            for (int j = 0; j < t.length() + 1; j++) {
//                System.out.print(resultMatrix[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

}
