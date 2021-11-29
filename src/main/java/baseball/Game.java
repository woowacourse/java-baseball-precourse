package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;

import baseball.Input;

public class Game {
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;
    static final int INPUT_LEN = 3;

    public static boolean oneTry(String rightAnswer) {
        String userInput = Input.getNumber(
                "숫자를 입력해주세요 : ",
                MIN_NUM, MAX_NUM, INPUT_LEN);

        if (Judge.isCorrect(rightAnswer, userInput, INPUT_LEN)) {
            return true;
        }
        return false;
    }

    public static String randomNumberGenerator(int startInclusive, int endInclusive, int count) {
        LinkedHashSet<Integer> randomNumber = new LinkedHashSet<>();
        while (randomNumber.size() < count) {
            randomNumber.add(Integer.valueOf(Randoms.pickNumberInRange(startInclusive, endInclusive)));
        }

        Iterator<Integer> randomNumberIter = randomNumber.iterator();
        String resultRandomNumber = "";
        while (randomNumberIter.hasNext()) {
            resultRandomNumber += randomNumberIter.next() + "";
        }

        return resultRandomNumber;
    }
}
