package baseball.engine;

import baseball.data.GameData;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

    private List<Integer> generateAnswer() {
        List<Integer> results = new ArrayList<Integer>();

        while(results.size() < GameData.NUM_OF_ANSWER) {
            Integer number = Integer.valueOf(Randoms.pickNumberInRange(0, 9));
            if(!results.contains(number)) {
                results.add(number);
            }
        }

        return results;
    }

    private int inputUserNumber() {
        String text = Console.readLine();
        int result = 0;

        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(text, nfe);
        }

        return result;
    }

    private List<Integer> parseUserNumber(int userNumber) {
        List<Integer> results = new ArrayList<Integer>();

        do {
            results.add(Integer.valueOf(userNumber % 10));
            userNumber /= 10;
        } while (userNumber != 0);

        if(results.size() != GameData.NUM_OF_ANSWER) {
            throw new IllegalArgumentException(Integer.toString(userNumber));
        }

        Collections.reverse(results);

        return results;
    }

}
