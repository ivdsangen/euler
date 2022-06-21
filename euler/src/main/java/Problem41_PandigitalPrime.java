public class Problem41_PandigitalPrime {

    private static int largestPandigitalPrime = 0;

    public static void main(String[] args) {
        for (int sequenceLength = 1; sequenceLength < 10; sequenceLength++) {
            StringBuilder sequence = new StringBuilder();
            for (int i = 1; i <= sequenceLength; i++) {
                sequence.append(i);
            }
            findPandigitalPrimes("", sequence.toString());
        }
        System.out.println(largestPandigitalPrime);
    }

    private static void findPandigitalPrimes(String prefix, String sequence) {
        if ("".equals(sequence)) {
            int value = Integer.parseInt(prefix);
            if (isPandigital(prefix) && isPrime(value) && value > largestPandigitalPrime) {
                largestPandigitalPrime = value;
            }
            return;
        }
        for (int i = 0; i < sequence.length(); i++) {
            String newPrefix = prefix + sequence.charAt(i);
            String newSequence = sequence.substring(0, i) + sequence.substring(i+1);
            findPandigitalPrimes(newPrefix,newSequence);
        }
    }

    private static boolean isPrime(int n) {
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0)
                return false;
        }
        return true;
    }

    private static boolean isPandigital(String string) {
        int[] indexHit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < string.length(); i++) {
            indexHit[Integer.parseInt(string.substring(i, i + 1))] += 1;
        }
        for (int i = 0; i < indexHit.length; i++) {
            if (i == 0)
                continue;
            if (i < string.length() && indexHit[i] != 1)
                return false;
        }
        return true;
    }
}
