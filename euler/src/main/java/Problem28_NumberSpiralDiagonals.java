public class Problem28_NumberSpiralDiagonals {

    private static final int NUM_SQUARES = 1001 * 1001;

    public static void main(String[] args) {
        int step = 1;
        int sum = 1;
        int x = 0;
        int y = 0;
        int direction = 0;
        boolean increaseStep = false;
        for (int i = 1; i <= NUM_SQUARES;) {
            if (direction == 0) {
                for (int j = 0; j < step; j++) {
                    x += 1;
                    i++;
                    if (Math.abs(x) == Math.abs(y))
                        sum += i;
                }
                direction = 1;
            } else if (direction == 1) {
                for (int j = 0; j < step; j++) {
                    y -= 1;
                    i++;
                    if (Math.abs(x) == Math.abs(y))
                        sum += i;
                }
                direction = 2;
            } else if (direction == 2) {
                for (int j = 0; j < step; j++) {
                    x -= 1;
                    i++;
                    if (Math.abs(x) == Math.abs(y))
                        sum += i;
                }
                direction = 3;
            } else {
                for (int j = 0; j < step; j++) {
                    y += 1;
                    i++;
                    if (Math.abs(x) == Math.abs(y))
                        sum += i;
                }
                direction = 0;
            }
            if (increaseStep)
                step++;
            increaseStep = !increaseStep;
        }
        System.out.println(sum);
    }
}
