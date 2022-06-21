import java.math.BigInteger;

public class Problem48_SelfPowers {

    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            BigInteger power = BigInteger.valueOf(i).pow(i);
            sum = sum.add(power);
        }
        String string = sum.toString();
        System.out.println(string.substring(string.length() - 10));
    }
}
