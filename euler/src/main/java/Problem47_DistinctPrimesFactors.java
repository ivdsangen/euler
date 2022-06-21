import java.util.ArrayList;
import java.util.List;

public class Problem47_DistinctPrimesFactors {

    public static void main(String[] args) {
        primes.add(2);
        int state = 0;
        for (int i = 6;; i++) {
            if (state == 4) {
                System.out.println(i - 4);
                break;
            }
            if (hasFourDistinctPrimeFactors(i)) {
                state++;
            } else {
                state = 0;
            }
        }
    }

    private static boolean hasFourDistinctPrimeFactors(int n) {
        precalculatePrimes(n / 2 + 1);
        int count = 0;
        for (int p : primes) {
            if (n % p == 0)
                count++;
        }
        return count == 4;
    }

    private static final List<Integer> primes = new ArrayList<>();

    private static void precalculatePrimes(int n) {
        while (primes.get(primes.size() - 1) < n) {
            for (int m = primes.get(primes.size() - 1) + 1;; m++) {
                boolean isPrime = true;
                for (int o = 2; o * o <= m; o++) {
                    if (m % o == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(m);
                    if (m >= n)
                        break;
                }
            }
        }
    }
}
