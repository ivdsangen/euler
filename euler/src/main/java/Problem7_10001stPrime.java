public class Problem7_10001stPrime {

    public static void main(String[] args) {
        int primesFound = 0;
        int lastPrime;
        for (int i = 2;; i++) {
            boolean prime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (!prime) continue;
            primesFound++;
            lastPrime = i;
            if (primesFound == 10001) break;
        }
        System.out.println(lastPrime);
    }
}
