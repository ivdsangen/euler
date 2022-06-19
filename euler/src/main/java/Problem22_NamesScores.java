import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem22_NamesScores {

    public static void main(String[] args) {
        File namesFile = new File(Objects.requireNonNull(
                Problem22_NamesScores.class.getClassLoader().getResource("p022_names.txt")).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(namesFile);
        } catch (FileNotFoundException e) {
            System.err.println("File p022_names.txt not found");
            System.exit(1);
        }
        String namesString = scanner.nextLine();
        List<String> names = new java.util.ArrayList<>(Arrays.stream(
                namesString.split(",")).map(s -> s.substring(1, s.length() - 1)).toList());
        names.sort(String::compareTo);
        Map<Character, Integer> scores = new HashMap<>();
        scores.put('A', 1);
        scores.put('B', 2);
        scores.put('C', 3);
        scores.put('D', 4);
        scores.put('E', 5);
        scores.put('F', 6);
        scores.put('G', 7);
        scores.put('H', 8);
        scores.put('I', 9);
        scores.put('J', 10);
        scores.put('K', 11);
        scores.put('L', 12);
        scores.put('M', 13);
        scores.put('N', 14);
        scores.put('O', 15);
        scores.put('P', 16);
        scores.put('Q', 17);
        scores.put('R', 18);
        scores.put('S', 19);
        scores.put('T', 20);
        scores.put('U', 21);
        scores.put('V', 22);
        scores.put('W', 23);
        scores.put('X', 24);
        scores.put('Y', 25);
        scores.put('Z', 26);
        long score = 0;
        long count = 1;
        for (String name : names) {
            for (int i = 0; i < name.length(); i++) {
                score += count * scores.get(name.charAt(i));
            }
            count++;
        }
        System.out.println(score);
    }
}
