import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, Deque<Integer> stopsStack, int currentPos) {
        if(currentPos + tank >= dist) {
            return 0;
        }
        if(stopsStack.isEmpty() || (stopsStack.peek() - currentPos) > tank) {
            return -1;
        }
        int lastStop = currentPos;
        while(!stopsStack.isEmpty() && (stopsStack.peek() - currentPos) <= tank){
            lastStop = stopsStack.pop();
        }

        int result = computeMinRefills(dist, tank, stopsStack, lastStop);
        if(result == -1) {
            return -1;
        } else {
            return 1 + result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        Deque<Integer> stopsStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stopsStack.addLast(scanner.nextInt());
        }

        System.out.println(computeMinRefills(dist, tank, stopsStack, 0));
    }
}
