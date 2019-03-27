/*
 * Class Name: Baseball
 *
 * Version: 1.0
 *
 * Date: 2019.03.27
 */

import java.util.ArrayList;
import java.util.Random;

public class Baseball {
    int[] computer = new int[3];
    int[] user = new int[3];

    Baseball() {
        this.getRandomNumbers();
    }

    private void getRandomNumbers() {
        Random rand = new Random();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int j=0; j<3; j++) {
            int index;

            index = rand.nextInt(8 - j);
            this.computer[j] = numbers.get(index);
            numbers.remove(index);
        }
    }
}
