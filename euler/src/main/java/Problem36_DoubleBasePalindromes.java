import java.util.ArrayList;
import java.util.List;

public class Problem36_DoubleBasePalindromes {

    public static void main(String[] args) {
        int sum = 0;
        for (int n = 1; n < 1000000; n++) {
            if (isPalindromeTen(n) && isPalindromeTwo(n))
                sum += n;
        }
        System.out.println(sum);
    }

    private static boolean isPalindromeString(String string) {
        int front = 0;
        int rear = string.length() - 1;
        while (front < rear) {
            if (string.charAt(front) != string.charAt(rear))
                return false;
            front++;
            rear--;
        }
        return true;
    }

    private static boolean isPalindromeTwo(int n) {
        List<Integer> binaryDigits = new ArrayList<>();
        while (n > 1) {
            binaryDigits.add(n % 2);
            n /= 2;
        }
        binaryDigits.add(1);
        StringBuilder binaryString = new StringBuilder();
        for (int i = binaryDigits.size() - 1; i >= 0; i--) {
            binaryString.append(binaryDigits.get(i));
        }
        return isPalindromeString(binaryString.toString());
    }

    private static boolean isPalindromeTen(int n) {
        return isPalindromeString(String.valueOf(n));
    }
}
