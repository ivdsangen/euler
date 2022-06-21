import java.util.ArrayList;
import java.util.List;

public class Problem40_ChampernownesConstant {

    public static void main(String[] args) {
        System.out.println(index(1) * index(10) * index(100) * index(1000) * index(10000) * index(100000) * index(1000000));
    }

    private static final List<Integer> stream = new ArrayList<>();

    private static int currentValue = 1;

    private static int index(int i) {
        while (stream.size() < i) {
            String string = String.valueOf(currentValue);
            for (int j = 0; j < string.length(); j++) {
                stream.add(Integer.parseInt(string.substring(j, j + 1)));
            }
            currentValue++;
        }
        return stream.get(i - 1);
    }
}
