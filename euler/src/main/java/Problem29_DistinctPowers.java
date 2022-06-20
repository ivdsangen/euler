import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem29_DistinctPowers {

    private static List<BigInteger> distinctPowers = new ArrayList<>();

    public static void main(String[] args) {

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger power = BigInteger.valueOf(a).pow(b);
                if (!distinctPowers.contains(power))
                    distinctPowers.add(power);
            }
        }
        distinctPowers.sort(BigInteger::compareTo);
        System.out.println(distinctPowers.size());
    }
}
