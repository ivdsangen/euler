public class Problem9_SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        for (int a = 1; a < 999; a++) {
            for (int b = a; b < 999; b++) {
                int c = 1000 - a - b;
                if (c < 1)
                    continue;
                if (a * a + b * b == c * c) {
                    System.out.printf("%d%n", a * b * c);
                }
            }
        }
    }
}
