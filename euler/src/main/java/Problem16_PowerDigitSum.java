import java.math.BigInteger;

public class Problem16_PowerDigitSum {

    public static void main(String[] args) {
        String result = new BigInteger("2").pow(1000).toString();
        int sum = 0;
        for (int i = 0; i < result.length(); i++) {
            sum += Integer.parseInt(result.substring(i, i+1));
        }
        System.out.println(sum);
    }
}
