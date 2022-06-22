public class Problem49_PrimePermutations {

    public static void main(String[] args) {
        for (int n = 1000; n < 10000; n++) {
            if (n == 1487)
                continue;
            if (!isPrime(n))
                continue;
            for (int addition = 1000; addition <= 4000; addition++) {
                if (isPermutationAndPrime(n, n + addition) && isPermutationAndPrime(n, n + 2 * addition))
                    System.out.println(n + "" + (n + addition) + "" + (n +  2 * addition));
            }
        }
    }

    private static boolean isPermutationAndPrime(int n1, int n2) {
        if (!isPrime(n2))
            return false;
        String number1 = String.valueOf(n1);
        String number2 = String.valueOf(n2);
        if (number1.length() != number2.length())
            return false;
        return checkPermutation(number1, number2) && checkPermutation(number2, number1);
    }

    private static boolean checkPermutation(String number1, String number2) {
        for (char c : number1.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < number2.length(); i++) {
                if (c == number2.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found)
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
