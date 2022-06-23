import java.math.BigInteger;

public class Problem56_PowerfulDigitSum {

    public static void main(String[] args) {
        BigInteger maximum = BigInteger.ZERO;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                maximum = maximum.max(digitalSum(BigInteger.valueOf(a).pow(b)));
            }
        }
        System.out.println(maximum);
    }

    private static BigInteger digitalSum(BigInteger integer) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < integer.toString().length(); i++) {
            sum = sum.add(BigInteger.valueOf(Integer.parseInt(integer.toString().substring(i, i+ 1))));
        }
        return sum;
    }
}
