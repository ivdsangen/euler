import java.util.ArrayList;
import java.util.List;

public class Problem46_GoldbachsOtherConjecture {

    public static void main(String[] args) {
        primes.add(2);
        for (int i = 1;; i += 2) {
            precalculatePrimes(i);
            if (isComposite(i) && !sumPrimeTwiceSquare(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean sumPrimeTwiceSquare(int n) {
        for (int prime : primes) {
            for (int i = 1; 2 * i * i <= n; i++) {
                if (n == prime + 2 * i * i)
                    return true;
            }
        }
        return false;
    }

    private static boolean isComposite(int n) {
        precalculatePrimes(n);
        for (int prime1 : primes) {
            for (int prime2 : primes) {
                if (prime1 * prime2 == n)
                    return true;
            }
        }
        return false;
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
