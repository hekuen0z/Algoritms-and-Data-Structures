import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money, int[] coins) {
        int[] MinNumCoins = new int[money + 1];
        MinNumCoins[0] = 0;
        for (int i = 1; i < money + 1; i++) {
            MinNumCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]){
                    int numCoins = MinNumCoins[i - coins[j]] + 1;
                    if(numCoins < MinNumCoins[i]){
                        MinNumCoins[i] = numCoins;
                    }
                }
            }
        }
        return MinNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int[] coins = {1, 3, 4};
        System.out.println(getChange(money, coins));

    }
}

