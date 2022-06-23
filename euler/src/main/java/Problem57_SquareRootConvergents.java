import java.math.BigInteger;

public class Problem57_SquareRootConvergents {

    public static void main(String[] args) {

        BigInteger n = BigInteger.valueOf(3);
        BigInteger d = BigInteger.TWO;
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            BigInteger nextN = n.add(d.multiply(BigInteger.TWO));
            BigInteger nextD = n.add(d);
            if (nextN.toString().length() > nextD.toString().length())
                count++;
            n = nextN;
            d = nextD;
        }
        System.out.println(count);
    }
}
