import java.util.Scanner;

public class Sum_of_two_numbers {

    public static void main(String[] args) {
        int a, b, sum = 0;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        sum = a + b;
        System.out.println(sum);
    }
}
