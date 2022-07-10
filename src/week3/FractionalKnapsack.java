
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, List<Integer> values, List<Integer> weights) {
        if(capacity <= 0 || weights.size() == 0){
            return 0;
        }
        double value = 0;
        double ratioValueWeight = 0;
        int indMaxValue = 0;
        for (int i = 0; i < values.size() && i < weights.size(); i++) {
            if((double)values.get(i) / weights.get(i) > ratioValueWeight) {
                indMaxValue = i;
                ratioValueWeight = (double) values.get(i) / weights.get(i);
            }
        }
        int amount = Math.min(weights.get(indMaxValue), capacity);
        value = values.get(indMaxValue) * ((double)amount / weights.get(indMaxValue));
        capacity -= amount;

        values.remove(indMaxValue);
        weights.remove(indMaxValue);

        return value + getOptimalValue(capacity, values, weights);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Integer> values = new ArrayList<>(n);
        List<Integer> weights = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            values.add(i, scanner.nextInt());
            weights.add(i, scanner.nextInt());
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
