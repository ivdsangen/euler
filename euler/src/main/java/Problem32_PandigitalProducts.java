import java.util.SortedSet;
import java.util.TreeSet;

public class Problem32_PandigitalProducts {

    private static SortedSet<Integer> unusualProducts = new TreeSet<>();

    public static void main(String[] args) {
        int sum = 0;
        for (int a = 1; a <= 10000; a++) {
            for (int b = a; b <= 10000; b++) {
                int product = a * b;
                if (!unusualProducts.contains(product) && isPandigital(product, a, b)) {
                    unusualProducts.add(product);
                    sum += product;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean isPandigital(int product, int a, int b) {
        String string = product + String.valueOf(a) + b;
        if (string.length() != 9)
            return false;
        int[] indexHit = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
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
