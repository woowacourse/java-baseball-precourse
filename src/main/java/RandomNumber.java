import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public static int[] create(int digit, int minValue, int maxValue) {
        List<Integer> availableNumberList = new ArrayList<>();
        for (int i=minValue; i<=maxValue; i++) {
            availableNumberList.add(i);
        }

        Collections.shuffle(availableNumberList);

        int[] randomNumbers = new int[digit];
        for (int i=0; i<digit; i++) {
            randomNumbers[i] = availableNumberList.get(i);
        }

        return randomNumbers;
    }
}
