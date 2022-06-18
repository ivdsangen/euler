import java.math.BigInteger;

public class Problem20_FactorialDigitSum {

    private static String fact(long n) {
        BigInteger product = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        return product.toString();
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(fact(100)));
    }

    private static int sumDigits(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(number.substring(i, i + 1));
        }
        return sum;
    }
}
