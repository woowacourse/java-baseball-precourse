package baseball.controller;

import utils.RandomUtils;

import java.util.*;

public class Viewer {
    private static final int MAX_LENGTH_OF_BALL = 3;
    private static final char START_NUMBER_CHARACTER = '0';
    private static final char END_NUMBER_CHARACTER = '9';
    private static final int START_INTEGER_NUMBER = 0;
    private static final int END_INTEGER_NUMBER = 9;

    private final Scanner scanner;

    Viewer(final Scanner scanner) {
        this.scanner = scanner;
    }

    List<Integer> createBallsNumberList() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBallsDataToken = this.scanner.next();
        if (!this.isValidEachdateInputBallData(inputBallsDataToken)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumberList = new ArrayList<>();
        for (char eachTokenData : inputBallsDataToken.toCharArray()) {
            inputNumberList.add(eachTokenData - START_NUMBER_CHARACTER);
        }

        return inputNumberList;
    }

    private boolean isValidEachdateInputBallData(String inputBallData) {
        if (inputBallData.length() > MAX_LENGTH_OF_BALL) {
            return false;
        }

        Set<Character> selectedBaseballNumberSet = new HashSet<>();
        for (char eachBallCharacter : inputBallData.toCharArray()) {
            if (START_NUMBER_CHARACTER > eachBallCharacter || eachBallCharacter > END_NUMBER_CHARACTER
                    || !selectedBaseballNumberSet.add(eachBallCharacter)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> createRandomBallNumberList() {
        List<Integer> randomBallNumberList = new ArrayList<>();
        Set<Integer> setForCheckingSameData = new HashSet<>();

        int count = 0;
        while (count < MAX_LENGTH_OF_BALL) {
            int randomInputNumber = RandomUtils.nextInt(START_INTEGER_NUMBER, END_INTEGER_NUMBER);
            if (setForCheckingSameData.add(randomInputNumber)) {
                randomBallNumberList.add(randomInputNumber);
                count += 1;
            }
        }
        return randomBallNumberList;
    }
}
