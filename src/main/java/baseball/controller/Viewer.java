package baseball.controller;

import utils.RandomUtils;

import java.util.*;

public class Viewer {
    private static final int MAX_LENGTH_OF_BALL = 3;
    private static final char START_NUMBER_CHARACTER = '0';
    private static final char END_NUMBER_CHARACTER = '9';
    private static final int START_INTEGER_NUMBER = 1;
    private static final int END_INTEGER_NUMBER = 9;
    private static final int NOTHING_NUMBER = 0;
    private static final String ERROR_INPUT_MESSAGE = "[ERROR] : 입력한 숫자 정보는 잘 못된 정보입니다.";

    private final Scanner scanner;

    Viewer(final Scanner scanner) {
        this.scanner = scanner;
    }

    List<Integer> createBallsNumberList() {
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String inputBallsDataToken = this.scanner.next();
                return this.validateInputDataForMakingList(inputBallsDataToken);
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_INPUT_MESSAGE);
            }
        }
    }

    private List<Integer> validateInputDataForMakingList(String inputBallsDataToken) {
        if (!this.isValidEachInputBallData(inputBallsDataToken)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumberList = new ArrayList<>();
        for (char eachTokenData : inputBallsDataToken.toCharArray()) {
            inputNumberList.add(eachTokenData - START_NUMBER_CHARACTER);
        }

        return inputNumberList;
    }

    private boolean isValidEachInputBallData(String inputBallData) {
        if (inputBallData.length() > MAX_LENGTH_OF_BALL) {
            return false;
        }

        Set<Character> selectedBaseballNumberSet = new HashSet<>();
        for (char eachBallCharacter : inputBallData.toCharArray()) {
            if (START_NUMBER_CHARACTER >= eachBallCharacter || eachBallCharacter > END_NUMBER_CHARACTER
                    || !selectedBaseballNumberSet.add(eachBallCharacter)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> createRandomBallNumberList() {
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

    void printBaseballGameResult(boolean isNothing, int ballCount, int strikeCount) {
        if (isNothing) {
            System.out.print("낫싱");
        } else {
            this.printBallAndStrike(ballCount, strikeCount);
        }
        System.out.println();
    }

    private void printBallAndStrike(int ballCount, int strikeCount) {
        if (ballCount != NOTHING_NUMBER) {
            System.out.printf("%d볼 ", ballCount);
        }
        if (strikeCount != NOTHING_NUMBER) {
            System.out.printf("%d스트라이크", strikeCount);
        }
    }

    void printFinishGameMessage() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", MAX_LENGTH_OF_BALL);
    }

    int inputRestartOrStopFlag() {
        while (true) {
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return createValidateNumber();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(ERROR_INPUT_MESSAGE);
            }
        }
    }

    private int createValidateNumber() {
        String inputTokenData = this.scanner.next();
        return Integer.parseInt(inputTokenData);
    }
}
