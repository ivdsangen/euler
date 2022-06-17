public class Problem10_SummationOfPrimes {

    private final static int bound = 2000000;
    private static boolean[] prime = new boolean[bound];

    public static void main(String[] args) {
        for (int i = 0; i < bound; i++)
            prime[i] = true;
        for (int i = 2; i * i < bound; i++)
            for (int j = i * i; j < bound; j += i)
                prime[j] = false;
        long sum = 0;
        for (int i = 2; i < bound; i++)
            if (prime[i]) sum += i;
        System.out.println(sum);
    }
}
