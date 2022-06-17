import java.math.BigInteger;

public class Problem15_LatticePaths {

    private static BigInteger fact(int n) {
        BigInteger product = BigInteger.ONE;
        for (long p = 1; p <= n; p++) {
            product = product.multiply(BigInteger.valueOf(p));
        }
        return product;
    }


    public static void main(String[] args) {
        System.out.println(fact(40).divide(fact(20).multiply(fact(20))));
    }
}
