/**
 * class name : Game.class
 *
 * version : V0.1
 *
 * date : 2019.12.2
 *
 * copyright :
 *
 * description : 중복없는 랜덤한 세개의 수를 순서있이 생성하는 class
 *
 */

import java.util.ArrayList;
import java.util.Random;


public class Generator {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Random random = new Random();

    public void newResult() {
        result.clear();
        while (result.size() != 3) {
            int value = random.nextInt(9) + 1;

            if (!duplication(result, value)) {
                result.add(value);
            }
        }

    }


    public boolean duplication(ArrayList<Integer> compared, int value) {
        boolean isDuplicate = false;

        for (int i = 0; i < compared.size(); i++) {
            if (compared.get(i) == value) {
                isDuplicate = true;
            }
        }

        return isDuplicate;
    }

    public ArrayList<Integer> getResult() {
        return result;
    }
}
