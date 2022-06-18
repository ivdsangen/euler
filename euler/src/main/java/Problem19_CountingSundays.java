public class Problem19_CountingSundays {

    private static final int MONTHS_IN_CENTURY = 12 * 100;

    private static int day = 1;
    private static int month = 0;
    private static int sundays = 0;

    public static void main(String[] args) {
        for (month = 0; month < 12; month++) {
            advanceMonth(false);
        }
        for (; month < MONTHS_IN_CENTURY; month++) {
            advanceMonth(true);
        }
        System.out.println(sundays);
    }

    private static void advanceMonth(boolean countSundays) {
        day = (day + daysInAMonth(month)) % 7;
        if (countSundays && day == 0) sundays++;
    }

    private static int daysInAMonth(int month) {
        if (month % 12 == 0)
            return 31;
        if (month % 12 == 1) {
            if (leapYear(month))
                return 29;
            return 28;
        }
        if (month % 2 == 0)
            return 31;
        return 30;
    }

    private static boolean leapYear(int month) {
        if ((month / 12) % 400 == 0)
            return true;
        if ((month / 12) % 100 == 0)
            return false;
        return (month / 12) % 4 == 0;
    }

}
