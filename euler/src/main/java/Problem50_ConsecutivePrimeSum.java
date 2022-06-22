import java.util.ArrayList;
import java.util.List;

public class Problem50_ConsecutivePrimeSum {

    public static void main(String[] args) {
        primes.add(2);
        int longestPrimeSum = 0;
        int prime = 0;
        for (int n = 2; n < 1000000; n++) {
            if (!isPrime(n))
                continue;
            precalculatePrimes(2 * n);
            int primeSum = findlongestPrimeSum(n);
            if (primeSum > longestPrimeSum) {
                longestPrimeSum = primeSum;
                prime = n;
            }
        }
        System.out.println(prime);
    }

    private static int findlongestPrimeSum(int n) {
        int longest = 0;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            int i = start;
            while (sum < n && i < primes.size()) {
                sum += primes.get(i);
                i++;
            }
            if (sum == n) {
                if (i - start > longest) {
                    longest = i - start;
                }
            }
        }
        return longest;
    }

    private static boolean isPrime(int n) {
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0)
                return false;
        }
        return true;
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
