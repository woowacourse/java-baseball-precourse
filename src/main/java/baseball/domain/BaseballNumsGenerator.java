package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballNumsGenerator {
    private final static String NOT_NUMBER_RANGE_ONE_TO_NINE = "1에서 9사이의 숫자가 아닙니다.";

    public static BaseballNums generateRandomBaseballNums() {
        Set<Integer> randomBaseballNums = new HashSet<>();
        while (randomBaseballNums.size() != BaseballNums.BASEBALL_NUMBERS_LENGTH) {
            randomBaseballNums.add(Randoms.pickNumberInRange(
                    BaseballNums.MIN_BASEBALL_NUMBER,
                    BaseballNums.MAX_BASEBALL_NUMBER));
        }
        return new BaseballNums(new ArrayList<>(randomBaseballNums));
    }

    public static BaseballNums generateInputBaseballNums(String inputNum) {
        List<Integer> inputBaseBallNums = new ArrayList<>();
        for (int i = 0; i < inputNum.length(); i++) {
            isValidateRangeNumOneToNine(inputNum.charAt(i) - '0');
            inputBaseBallNums.add(inputNum.charAt(i) - '0');
        }
        return new BaseballNums(inputBaseBallNums);
    }

    private static void isValidateRangeNumOneToNine(int number) {
        if (BaseballNums.MIN_BASEBALL_NUMBER > number || number > BaseballNums.MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(NOT_NUMBER_RANGE_ONE_TO_NINE);
        }
    }
}