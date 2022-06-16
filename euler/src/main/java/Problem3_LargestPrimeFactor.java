import java.util.ArrayList;
import java.util.List;

public class Problem3_LargestPrimeFactor {

    private static final long n = 600851475143L;

    public static void main(String[] args) {
        long largestPrimeFactor = 0;
        long runningProduct = n;
        for (long i = 2; i * i <= n; i++) {
            if (runningProduct % i == 0) {
                largestPrimeFactor = i;
                runningProduct /= i;
            }
        }
        System.out.println(largestPrimeFactor);
    }
}
