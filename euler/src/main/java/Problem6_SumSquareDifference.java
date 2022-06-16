public class Problem6_SumSquareDifference {

    public static void main(String[] args) {
        int sumSquares = 0;
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumSquares += i*i;
            sum += i;
        }
        System.out.println((sum * sum) - sumSquares);
    }
}
