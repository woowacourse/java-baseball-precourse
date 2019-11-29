import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public static int[] create() {
        List<Integer> availableNumberList = new ArrayList<>();
        int[] randomNumbers = new int[NumberBaseBallGame.DIGIT];

        for (int i = NumberBaseBallGame.MIN_VALUE; i <= NumberBaseBallGame.MAX_VALUE; i++) {
            availableNumberList.add(i);
        }

        Collections.shuffle(availableNumberList);

        for (int i = 0; i < NumberBaseBallGame.DIGIT; i++) {
            randomNumbers[i] = availableNumberList.get(i);
        }

        return randomNumbers;
    }
}
