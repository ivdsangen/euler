import java.util.ArrayList;
import java.util.List;

public class Problem44_PentagonNumbers {

    public static void main(String[] args) {
        long difference = Long.MAX_VALUE;
        pentagonals.add(1L);
        for (int n = 1000; n < 3000; n++) {
            for (int m = 1000; m < 3000; m++) {
                long nn = pentagonal(n);
                long mm = pentagonal(m);
                precalculateValue(nn + mm);
                if (pentagonals.contains(nn + mm) && pentagonals.contains(Math.abs(mm - nn))) {
                    if (Math.abs(mm - nn) < difference) {
                        difference = Math.abs(mm - nn);
                    }
                }
            }
        }
        System.out.println(difference);
    }

    private static void precalculateValue(long n) {
        long value = pentagonals.get(pentagonals.size() - 1);
        while (value < n) {
            value = pentagonal(pentagonals.size());
            pentagonals.add(value);
        }
    }

    private static final List<Long> pentagonals = new ArrayList<>();

    private static int pentagonal(int n) {
        return (n * (3 * n - 1)) / 2;
    }
}
