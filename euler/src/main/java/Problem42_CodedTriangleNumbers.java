import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem42_CodedTriangleNumbers {

    private static final Map<Character, Integer> map = new HashMap<>();

    private static final SortedSet<Integer> triangleNumbers = new TreeSet<>();

    public static void main(String[] args) {
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);
        File wordsFile = new File(Objects.requireNonNull(
                Problem42_CodedTriangleNumbers.class.getClassLoader().getResource("p042_words.txt")).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(wordsFile);
        } catch (FileNotFoundException e) {
            System.err.println("File p022_words.txt not found");
            System.exit(1);
        }
        String wordsString = scanner.nextLine();
        List<String> words = new java.util.ArrayList<>(Arrays.stream(
                wordsString.split(",")).map(s -> s.substring(1, s.length() - 1)).toList());
        int count = 0;
        List<Integer> scores = new ArrayList<>();
        for (String word : words) {
            scores.add(score(word));
        }
        int maximumScore = scores.stream().max(Integer::compareTo).orElseThrow();
        calculateTriangleNumbers(maximumScore);
        for (int score : scores) {
            if (triangleNumbers.contains(score))
                count++;
        }
        System.out.println(count);
    }

    private static void calculateTriangleNumbers(int maximum) {
        for (int current = 1; t(current) <= maximum; current++) {
            triangleNumbers.add(t(current));
        }
    }

    private static int t(int n) {
        return (n*(n+1))/2;
    }

    private static Integer score(String word) {
        int score = 0;
        for (Character c : word.toCharArray()) {
            score += map.get(c);
        }
        return score;
    }
}
