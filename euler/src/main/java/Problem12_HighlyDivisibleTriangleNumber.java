public class Problem12_HighlyDivisibleTriangleNumber {

    private static long triangle(long n) {
        long sum = 0;
        for (long m = n; m > 0; m--) {
            sum += m;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (long n = 1;; n++) {
            long triangle = triangle(n);
            if (countDivisors(triangle) > 500) {
                System.out.println(triangle);
                System.exit(0);
            }
        }
    }

    private static long countDivisors(long n) {
        if (n == 1)
            return 1;
        long divisors = 0;
        for (long d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                divisors += 2;
            }

        }
        return divisors;
    }
}
