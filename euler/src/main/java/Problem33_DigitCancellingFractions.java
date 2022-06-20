public class Problem33_DigitCancellingFractions {

    public static void main(String[] args) {

        int numProduct = 1;
        int denProduct = 1;

        for (int i = 1; i < 10; i++) {
            for (int den = 1; den < i; den++) {
                for (int num = 1; num < den; num++) {
                    if ((den + 10 * i) * num == (num * 10 + i) * den) {
                        numProduct *= num;
                        denProduct *= den;
                    }
                }
            }
        }
        System.out.println(denProduct/gcd(numProduct, denProduct));

    }

    private static int gcd(int a, int b) {
        if (a <= b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(a % b != 0) {
            int tmp = a;
            a = a % b;
            b = tmp;
        }
        return b;
    }

}
