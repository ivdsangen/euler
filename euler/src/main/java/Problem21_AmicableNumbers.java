public class Problem21_AmicableNumbers {

    public static void main(String[] args) {
        int sum = 0;
        for (int a = 4; a < 10000; a++) {
            for (int b = a + 1; b < 10000; b++) {
                if (d(a) == b && d(b) == a) sum += a + b;
            }
        }
        System.out.println(sum);
    }

    private static int d(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (n / i != i)
                    sum += n / i;
            }
        }
        return sum;
    }
}
