public class Problem37_TruncatablePrimes {

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        for (int n = 11; count < 11; n++) {
            if (!isPrime(n))
                continue;
            String number  = String.valueOf(n);
            if (number.contains("0"))
                continue;
            boolean truncatable = true;
            for (int i = 0; i < number.length() && truncatable; i++) {
                String subString = number.substring(i);
                String subStringBackwards = number.substring(0, number.length() - i);
                truncatable = isPrime(Integer.parseInt(subString)) && isPrime(Integer.parseInt(subStringBackwards));
            }
            if (truncatable) {
                count++;
                sum += n;
            }
        }
        System.out.println(sum);
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
