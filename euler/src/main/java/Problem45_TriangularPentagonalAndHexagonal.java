public class Problem45_TriangularPentagonalAndHexagonal {
    public static void main(String[] args) {
        for (long i = 286;; i++) {
            long triangle = t(i);
            boolean found = findPentagonal(triangle);
            if (!found)
                continue;
            found = findHexagonal(triangle);
            if (found) {
                System.out.println(triangle);
                break;
            }
        }

    }

    private static long lastPentagonalIndex = 1;
    private static long lastPentagonal = 1;
    private static boolean findPentagonal(long n) {
        while (lastPentagonal < n) {
            lastPentagonalIndex++;
            lastPentagonal = p(lastPentagonalIndex);
        }
        return lastPentagonal == n;
    }

    private static long lastHexagonalIndex = 1;
    private static long lastHexagonal = 1;

    private static boolean findHexagonal(long n) {
        while(lastHexagonal < n) {
            lastHexagonalIndex++;
            lastHexagonal = h(lastHexagonalIndex);
        }
        return lastHexagonal == n;
    }

    private static long h(long n) {
        return n * (2 * n - 1);
    }

    private static long p(long n) {
        return (n * (3 * n - 1)) / 2;
    }

    private static long t(long n) {
        return (n * (n + 1)) / 2;
    }
}
