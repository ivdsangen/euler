import java.util.ArrayList;
import java.util.List;

public class Problem23_NonAbundantSums {

    private static List<Integer> abundantNumbers = new ArrayList<>();
    private static final int upperBound = 28123;

    public static void main(String[] args) {
        calculateAbundantNumbers(upperBound);
        long sum = 0;
        for (int i = 1; i <= 28123; i++) {
            if (!findAbundantSummation(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static int d(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (n / i != i)
                    sum += n / i;
            }
        }
        return sum;
    }
    private static void calculateAbundantNumbers(int upperBound) {
        for (int i = 12; i <= upperBound; i++) {
            if (d(i) > i) abundantNumbers.add(i);
        }
    }

    private static boolean findAbundantSummation(int n) {
        for (int i = 0; i < abundantNumbers.size(); i++) {
            if (abundantNumbers.get(i) >= n) return false;
            for (int j = 0; j < abundantNumbers.size(); j++) {
                if (abundantNumbers.get(j) >= n) break;
                if (abundantNumbers.get(i) + abundantNumbers.get(j) == n) return true;
            }
        }
        return false;
    }
}
