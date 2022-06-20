public class Problem31_CoinSums {

    private static int SUM = 200;
    private static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

    public static void main(String[] args) {
        int count = 0;
        for (int i0 = 0; i0 <= 200; i0++) {
            for (int i1 = 0; i1 <= 100; i1++) {
                for (int i2 = 0; i2 <= 40; i2++) {
                    for (int i3 = 0; i3 <= 20; i3++) {
                        for (int i4 = 0; i4 <= 10; i4++) {
                            for (int i5 = 0; i5 <= 4; i5++) {
                                for (int i6 = 0; i6 <= 2; i6++) {
                                    for (int i7 = 0; i7 <= 1; i7++) {
                                        if (i0 + i1 * 2 + i2 * 5 + i3 * 10 + i4 * 20 + i5 * 50 + i6 * 100 + i7 * 200 == SUM)
                                            count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
