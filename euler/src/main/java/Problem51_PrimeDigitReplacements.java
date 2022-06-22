import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem51_PrimeDigitReplacements {

    public static void main(String[] args) {
        primes.add(2);
        for (int pIndex = 0;; pIndex++) {
            precalculatePrimes(pIndex);
            int prime = primes.get(pIndex);
            int nDigits = String.valueOf(prime).length();
            for (int digits = 1; digits < nDigits; digits++) {
                List<Integer> chosenIndexes = new ArrayList<>();
                List<Integer> indexesToTry = new ArrayList<>();
                for (int i = 0; i < String.valueOf(prime).length(); i++)
                    indexesToTry.add(i);
                replaceDigits(String.valueOf(prime).toCharArray(), digits, indexesToTry, chosenIndexes);
            }
        }
    }

    private static final char[] values = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private static void replaceDigits(char[] prime, int digits, List<Integer> indexesToTry, List<Integer> chosenIndexes) {
        char[] clone = prime.clone();
        if (chosenIndexes.size() == digits) {
            int count = 0;
            boolean foundSelf = false;
            for (char value : values) {
                for (int index : chosenIndexes) {
                    clone[index] = value;
                }
                if (Arrays.equals(prime, clone))
                    foundSelf = true;
                if (clone[0] == '0')
                    continue;
                if (isPrime(Integer.parseInt(String.valueOf(clone)))) {
                    count++;
                }
            }
            if (count == 8 && foundSelf) {
                System.out.println(prime);
                System.exit(0);
            }
        }

        List<Integer> copyIndexesToTry = new ArrayList<>(indexesToTry);
        for (int index : indexesToTry) {
            copyIndexesToTry.remove((Object) index);
            chosenIndexes.add(index);
            replaceDigits(prime, digits, copyIndexesToTry, chosenIndexes);
            chosenIndexes.remove((Object) index);
        }
    }
    private static final List<Integer> primes = new ArrayList<>();

    private static void precalculatePrimes(int n) {
        while (primes.size() <= n) {
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

    private static boolean isPrime(int n) {
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0)
                return false;
        }
        return true;
    }
}
