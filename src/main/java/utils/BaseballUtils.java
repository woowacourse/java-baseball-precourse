package utils;

import baseball.Constant;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import baseball.BaseballStep;

public class BaseballUtils {

    static final int NUMBER_COUNT = Constant.NUMBER_COUNT.getValue();
    static final int MIN_NUMBER = Constant.MIN_NUMBER.getValue();
    static final int MAX_NUMBER = Constant.MAX_NUMBER.getValue();

    public static int[] generateRandomNumbers() {
        int[] randomNumbers = new int[NUMBER_COUNT];
        boolean[] checkNumbers = new boolean[MAX_NUMBER + 1];

        int count = 0;
        while (count < NUMBER_COUNT) {
            int random = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (checkNumbers[random]) {
                continue;
            }

            randomNumbers[count++] = random;
            checkNumbers[random] = true;
        }

        return randomNumbers;
    }

    public static int[] getPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        int playerInput = getIntInput(Console.readLine());
        return getValidNumbers(playerInput);
    }

    public static int getIntInput(String number) {
        int intNumber;
        try{
                intNumber = Integer.parseInt(number);

            return intNumber;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static int[] getValidNumbers(int playerInput) {
        int[] playerNumbers = new int[NUMBER_COUNT];
        boolean[] checkDuplicated = new boolean[MAX_NUMBER + 1];

        if (playerInput / 100 == 0 || playerInput / 1000 >= 1) {
            System.out.println("숫자 갯수 오류 발생");
            throw new IllegalArgumentException();
        }

        for (int i = NUMBER_COUNT - 1; i > 0; i--) {
            int division = (int) Math.pow(10, i);
            int number = playerInput / division;
            playerInput = playerInput % division;

            playerNumbers[NUMBER_COUNT - i - 1] = number;
        }
        playerNumbers[NUMBER_COUNT - 1] = playerInput;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (playerNumbers[i] < MIN_NUMBER || playerNumbers[i] > MAX_NUMBER) {
                System.out.println("범위 오류 발생");
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (checkDuplicated[playerNumbers[i]]) {
                System.out.println("중복 에러 발생");
                throw new IllegalArgumentException();
            }

            checkDuplicated[playerNumbers[i]] = true;
        }

        return playerNumbers;
    }

    public static boolean compareNumbers(int[] randomNumbers, int[] playerNumbers) {
        BaseballStep baseballStep = new BaseballStep(randomNumbers, playerNumbers);
        baseballStep.compare();
        System.out.println(baseballStep.toString());

        return baseballStep.isGameEnded();
    }

    public static boolean checkRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = getIntInput(Console.readLine());

        if (playerInput == 1) {
            return true;
        } else if (playerInput == 2) {
            return false;
        } else {
            System.out.println("1 또는 2가 아닌 오류 발생");
            throw new IllegalArgumentException();
        }
    }
}
