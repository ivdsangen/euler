import java.util.ArrayList;
import java.util.List;

public class Problem38_PandigitalMultiples {

    public static void main(String[] args) {
        int largestConcatenationValue = 1;
        for (int n = 2; n < 10; n++) {
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= n; i++)
                factors.add(i);
            for (int p = 1; p < 1000000000; p++) {
                StringBuilder concatenation = new StringBuilder();
                for (int m : factors)
                    concatenation.append(p * m);
                if (concatenation.toString().length() > 9) break;
                Integer concatenationValue = Integer.parseInt(concatenation.toString());
                if (isPandigital(concatenation.toString()) && (concatenationValue > largestConcatenationValue)) {
                    largestConcatenationValue = concatenationValue;
                }
            }
        }
        System.out.println(largestConcatenationValue);
    }

    private static boolean isPandigital(String string) {
        if (string.length() != 9)
            return false;
        int[] indexHit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < string.length(); i++) {
            indexHit[Integer.parseInt(string.substring(i, i + 1))] += 1;
        }
        for (int i = 0; i < indexHit.length; i++) {
            if (i == 0)
                continue;
            if (indexHit[i] != 1)
                return false;
        }
        return true;
    }
}
