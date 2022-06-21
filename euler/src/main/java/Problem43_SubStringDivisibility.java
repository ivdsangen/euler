public class Problem43_SubStringDivisibility {

    private static long sum = 0;

    public static void main(String[] args) {
        findDivisiblePandigitals("", "0123456789");
        System.out.println(sum);
    }

    private static void findDivisiblePandigitals(String prefix, String sequence) {
        if ("".equals(sequence)) {
            boolean isDivisible;
            isDivisible = Long.parseLong(prefix.substring(1, 4)) % 2 == 0;
            isDivisible &= Long.parseLong(prefix.substring(2, 5)) % 3 == 0;
            isDivisible &= Long.parseLong(prefix.substring(3, 6)) % 5 == 0;
            isDivisible &= Long.parseLong(prefix.substring(4, 7)) % 7 == 0;
            isDivisible &= Long.parseLong(prefix.substring(5, 8)) % 11 == 0;
            isDivisible &= Long.parseLong(prefix.substring(6, 9)) % 13 == 0;
            isDivisible &= Long.parseLong(prefix.substring(7, 10)) % 17 == 0;
            if (isDivisible)
                sum += Long.parseLong(prefix);
        }
        for (int i = 0; i < sequence.length(); i++) {
            String newPrefix = prefix + sequence.charAt(i);
            String newSequence = sequence.substring(0, i) + sequence.substring(i+1);
            findDivisiblePandigitals(newPrefix, newSequence);
        }
    }
}
