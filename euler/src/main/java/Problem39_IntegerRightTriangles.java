public class Problem39_IntegerRightTriangles {

    public static void main(String[] args) {
        int pMax = 0;
        int maxSolutions = 0;
        for (int p = 3; p <= 1000; p++) {
            int numSolutions = 0;
            for (int a = 1; a < p - 1; a++) {
                for (int b = a; b < p - 1; b++) {
                    int c = p - a - b;
                    if (c <= 0 || c * c != a * a + b * b)
                        continue;
                    numSolutions++;
                }
            }
            if (numSolutions > maxSolutions) {
                pMax = p;
                maxSolutions = numSolutions;
            }
        }
        System.out.println(pMax);
    }

}
