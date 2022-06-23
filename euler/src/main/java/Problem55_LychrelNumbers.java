import java.math.BigInteger;

public class Problem55_LychrelNumbers {

    public static void main(String[] args) {

        int count = 0;
        for (int n = 0; n < 10000; n++) {
            BigInteger m = BigInteger.valueOf(n);
            int i = 0;
            boolean isPalindrome;
            do {
                BigInteger reverse = new BigInteger(reverse(m.toString()));
                m = m.add(reverse);
                i++;
                isPalindrome = isPalindrome(m.toString());
            } while (i < 50 && !isPalindrome);
            if (!isPalindrome)
                count++;
        }
        System.out.println(count);
    }

    private static boolean isPalindrome(String string) {
        int front = 0;
        int rear = string.length() - 1;
        while (front < rear) {
            if (string.charAt(front) != string.charAt(rear)) return false;
            front++;
            rear--;
        }
        return true;
    }

    private static String reverse(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            char c = string.toCharArray()[i];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
