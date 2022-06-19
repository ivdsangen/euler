import java.util.ArrayList;
import java.util.List;

public class Problem24_LexicographicPermutations {

    private static String digits = "0123456789";

    private static List<String> permutations = new ArrayList<>();

    public static void main(String[] args) {

        generatePermutations("", digits);
        System.out.println(permutations.get(999999));

    }

    private static void generatePermutations(String prefix, String digits) {
        if (digits.length() == 0) permutations.add(prefix);
        for (int i = 0; i < digits.length(); i++) {
            generatePermutations(prefix + digits.charAt(i), digits.substring(0, i) + digits.substring(i+1));
        }
    }
}
