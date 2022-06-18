public class Problem17_NumberLetterCounts {

    private static final String[] oneCounts = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    private static final String[] tenTwentyCounts = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] twentyCounts = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
            "ninety"};
    private static final String hundred = "hundred";
    private static final String and = "and";
    private static final String thousand = "thousand";

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i < 10) {
                sum += oneCounts[i-1].length();
            } else if (i < 20) {
                sum += tenTwentyCounts[i % 10].length();
            } else if (i < 100) {
                if (i % 10 != 0) {
                    sum += oneCounts[(i % 10) - 1].length();
                }
                sum += twentyCounts[((i / 10) % 10) - 2].length();
            } else if ( i < 1000) {
                if (i % 100 == 0) {
                    sum += oneCounts[(i / 100) - 1].length();
                    sum += hundred.length();
                } else {
                    sum += and.length();
                    sum += oneCounts[(i / 100) - 1].length();
                    sum += hundred.length();
                    if (i % 100 < 10) {
                        sum += oneCounts[(i % 10) - 1].length();
                    } else if (i % 100 < 20) {
                        sum += tenTwentyCounts[(i % 10)].length();
                    } else {
                        if (i % 10 != 0) {
                            sum += oneCounts[(i % 10) - 1].length();
                        }
                        sum += twentyCounts[((i % 100) / 10) - 2].length();
                    }
                }
            } else if (i == 1000) {
                sum += oneCounts[0].length();
                sum += thousand.length();
            }
        }
        System.out.println(sum);
    }
}
