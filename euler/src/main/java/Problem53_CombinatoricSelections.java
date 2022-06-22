import java.math.BigInteger;

public class Problem53_CombinatoricSelections {

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int n = 23; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                BigInteger combination = factorial(n).divide(factorial(r).multiply(factorial(n - r)));
                if (combination.compareTo(BigInteger.valueOf(1000000)) > 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
