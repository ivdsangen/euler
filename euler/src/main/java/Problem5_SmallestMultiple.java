public class Problem5_SmallestMultiple {

    public static void main(String[] args) {
        for (int i = 21;; i++) {
            boolean found = true;
            for (int j = 2; j <= 20; j++) {
                if (i % j != 0) {
                    found = false;
                    break;
                }
            }
            if (!found) continue;
            System.out.println(i);
            break;
        }
    }
}
