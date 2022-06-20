public class Problem30_DigitFifthPowers {

    public static void main(String[] args) {
        int sumNumbers = 0;
        for (int i = 10; i < 1000000; i++) {
            int sumDigits = 0;
            String number = String.valueOf(i);
            for (int j = 0; j < number.length(); j++) {
                int digit = Integer.parseInt(number.substring(j, j + 1));
                sumDigits += Math.pow(digit, 5);
            }
            if (sumDigits == i)
                sumNumbers += sumDigits;
        }
        System.out.println(sumNumbers);
    }
}
