public class Problem27_QuadraticPrimes {

    public static void main(String[] args) {
        int sequenceLength = 0;
        int maxA = 0, maxB = 0;
        for (int a = -999; a <= 999; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int currentSequenceLength = calculateSequence(a, b);
                if (currentSequenceLength > sequenceLength) {
                    sequenceLength = currentSequenceLength;
                    maxA = a;
                    maxB = b;
                }
            }
        }
        System.out.println(maxA*maxB);
    }

    private static int calculateSequence(int a, int b) {
        int sequenceLength = 0;
        int n = 0;
        while (isPrime(n*n + a*n + b)) {
            sequenceLength++;
            n++;
        }
        return sequenceLength;
    }

    private static boolean isPrime(int n) {
        if (n < 0 || n == 0 || n == 1) return false;
        for (int d = 2; d*d <= n; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }
}
