public class Problem52_PermutedMultiples {

    public static void main(String[] args) {
        for (int i = 1;; i++) {
            String number1 = String.valueOf(i);
            boolean sameDigits = true;
            for (int factor = 1; factor <= 6; factor++) {
                String number2 = String.valueOf(factor * i);
                sameDigits &= checkDigits(number1, number2);
            }
            if (sameDigits) {
                System.out.println(number1);
                System.exit(0);
            }
        }
    }

    private static boolean checkDigits(String number1, String number2) {
        if (number1.length() != number2.length())
            return false;
        char[] array1 = number1.toCharArray();
        char[] array2 = number2.toCharArray();
        for (char i : array1) {
            int count = 0;
            for (char j : array2) {
                if (i == j)
                    count++;
            }
            if (count != 1)
                return false;
        }
        return true;
    }
}
