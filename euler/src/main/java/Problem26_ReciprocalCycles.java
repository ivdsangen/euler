import java.util.ArrayList;
import java.util.List;

public class Problem26_ReciprocalCycles {

    public static void main(String[] args) {
        int maxCycle = 0;
        int maxCycleIndex = 0;
        for (int i = 2; i < 1000; i++) {
            if (maxCycle < cycle(i)) {
                maxCycle = cycle(i);
                maxCycleIndex = i;
            }
        }
        System.out.println(maxCycleIndex);
    }

    private static int cycle(int n) {
        List<Integer> remainders = new ArrayList<>();
        int remainder = 1;
        int length = 1;
        while (!remainders.contains(remainder)) {
            remainders.add(remainder);
            remainder = (remainder * 10) % n;
            length++;
        }
        return length;
    }

}
