public class Problem35_CircularPrimes {

    public static void main(String[] args) {
        int count = 0;
        for (int n = 2; n < 1000000; n++) {
            if (isPrime(n) && isCircular(String.valueOf(n)))
                count++;
        }
        System.out.println(count);
    }

    private static boolean isCircular(String n) {
        for (int i = 0; i < n.length(); i++) {
            String rotation = n.substring(i) + n.substring(0, i);
            if (!isPrime(Integer.parseInt(rotation)))
                return false;
        }
        return true;
    }

    private static boolean isPrime(int n) {
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0)
                return false;
        }
        return true;
    }
}
