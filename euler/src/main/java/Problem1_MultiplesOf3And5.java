import java.util.ArrayList;
import java.util.List;

public class Problem1_MultiplesOf3And5 {

    public static void main(String[] args) {
        List<Integer> multiplesOf3And5 = new ArrayList<>();
        for (int i = 1; i < 1000; i++)
            if ((i % 3 == 0) || (i % 5 == 0))
                multiplesOf3And5.add(i);

        System.out.println(multiplesOf3And5.stream().reduce(0, Integer::sum));

    }
}
