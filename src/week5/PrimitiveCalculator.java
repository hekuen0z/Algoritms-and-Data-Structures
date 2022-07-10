import java.util.*;

public class PrimitiveCalculator {
    private static int[] optimal_sequence(int n) {
        List<List<Integer>> minNumberCalc = new ArrayList<>(n + 1);
        List<Integer> tempOne = new ArrayList<>(2);
        tempOne.add(0, 0);
        tempOne.add(1, 1);
        minNumberCalc.add(0, Collections.singletonList(0));
        minNumberCalc.add(1, tempOne);
        for (int i = 2; i < n + 1; i++) {
            int resultDivByTwo = Integer.MAX_VALUE, resultDivByThree = Integer.MAX_VALUE, resultAddOne;
            if(i % 2 == 0) resultDivByTwo = minNumberCalc.get(i / 2).get(0) + 1;
            if(i % 3 == 0) resultDivByThree = minNumberCalc.get(i / 3).get(0) + 1;
            resultAddOne = minNumberCalc.get(i - 1).get(0) + 1;
            int minResultTemp = Math.min(resultAddOne, Math.min(resultDivByTwo, resultDivByThree));
            if(minResultTemp == resultAddOne) {
                List<Integer> integers = new ArrayList<>();
                integers.add(0, minResultTemp);
                for (int j = 1; j < minNumberCalc.get(i - 1).size(); j++) {
                    integers.add(j, minNumberCalc.get(i - 1).get(j));
                }
                integers.add(i);
                minNumberCalc.add(i, integers);
            } else if(minResultTemp == resultDivByTwo) {
                List<Integer> integers = new ArrayList<>();
                integers.add(0, minResultTemp);
                for (int j = 1; j < minNumberCalc.get(i / 2).size(); j++) {
                    integers.add(j, minNumberCalc.get(i / 2).get(j));
                }
                integers.add(i);
                minNumberCalc.add(i, integers);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(0, minResultTemp);
                for (int j = 1; j < minNumberCalc.get(i / 3).size(); j++) {
                    integers.add(j, minNumberCalc.get(i / 3).get(j));
                }
                integers.add(i);
                minNumberCalc.add(i, integers);
            }
        }
        int[] resultSequence = new int[minNumberCalc.get(n).get(0) + 1];
        for (int i = 1; i < minNumberCalc.get(n).size(); i++) {
            resultSequence[i - 1] = minNumberCalc.get(n).get(i);
        }
        return resultSequence;
    }

//    List<List<Integer>> minNumberCalc = new ArrayList<>(n + 1);
//        for (int i = 2; i < n + 1; i++) {
//        int resultDivByTwo = Integer.MAX_VALUE, resultDivByThree = Integer.MAX_VALUE, resultAddOne;
//        if(i % 2 == 0) resultDivByTwo = minNumberCalc[i / 2] + 1;
//        if(i % 3 == 0) resultDivByThree = minNumberCalc[i / 3] + 1;
//        resultAddOne = minNumberCalc[i - 1] + 1;
//        minNumberCalc[i] = Math.min(resultAddOne, Math.min(resultDivByTwo, resultDivByThree));
//    }
//    int[] resultSequence = new int[minNumberCalc[n]];
//
//        return resultSequence;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sequence = optimal_sequence(n);
        System.out.println(sequence.length - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

