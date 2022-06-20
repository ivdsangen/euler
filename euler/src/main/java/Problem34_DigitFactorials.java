public class Problem34_DigitFactorials {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 3; i < 100000; i++) {
            if (i == digitFactorial(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static long fact(long n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    private static int digitFactorial(int n) {
        String numberString = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < numberString.length(); i++) {
            sum += fact(Integer.parseInt(numberString.substring(i, i + 1)));
        }
        return sum;
    }
}
