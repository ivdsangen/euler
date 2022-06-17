public class Problem14_LongestCollatzSequence {

    private static long collatz(long n) {
        if (n % 2 == 0)
            return n / 2;
        else
            return 3 * n + 1;
    }

    public static void main(String[] args) {
        int countMax = 0;
        long longest = 0;
        for (int n = 3; n < 1000000; n++) {
            long m = n;
            int count = 0;
            do {
                m = collatz(m);
                count++;
            } while((m != 1) && (m != 2));
            if (m == 2) count++;
            if (count > countMax) {
                countMax = count;
                longest = n;
            }
        }
        System.out.println(longest);
    }
}
