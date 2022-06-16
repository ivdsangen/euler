public class Problem2_EvenFibonacciNumbers {
    public static void main(String[] args) {
        long fib1, fib0;
        fib0 = 1;
        fib1 = 2;
        long sum = 2;
        for (;;) {
            long fib_next = fib0 + fib1;
            if (fib_next > 4000000)
                break;
            if (fib_next % 2 == 0) sum += fib_next;
            fib0 = fib1;
            fib1 = fib_next;
        }
        System.out.println(sum);
    }
}
