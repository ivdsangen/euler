import java.util.ArrayList;
import java.util.List;

public class Problem58_SpiralPrimes {

    private static final List<Integer> primesOnDiagonal = new ArrayList<>();

    public static void main(String[] args) {
        int numPrimes = 0;
        int n = 1;
        for (; ; n += 2) {
            for (int i = 0; i < 4; i++) {
                if (isPrime(n * n - i * (n - 1)))
                    numPrimes++;
            }
            if (n > 1 && numPrimes * 10 < n * 2 - 1)
                break;
        }
        System.out.println(n);
    }

    private static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0)
                return false;
        }
        return true;
    }
}