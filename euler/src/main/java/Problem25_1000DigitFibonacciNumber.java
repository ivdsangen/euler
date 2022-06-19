import java.math.BigInteger;

public class Problem25_1000DigitFibonacciNumber
{
    public static void main(String[] args) {
        BigInteger n = BigInteger.ONE;
        BigInteger m = BigInteger.ONE;
        int index = 2;
        do {
            BigInteger next_n = n.add(m);
            BigInteger next_m = n;
            n = next_n;
            m = next_m;
            index++;
        } while (n.toString().length() < 1000);
        System.out.println(index);
    }
}
