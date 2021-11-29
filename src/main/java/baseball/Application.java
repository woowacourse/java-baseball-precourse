package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static String getRandomNumber() {
        int firstNumber = Randoms.pickNumberInRange(1, 9);
        int secondNumber;
        int thirdNumber;

        do {
            secondNumber = Randoms.pickNumberInRange(1, 9);
        } while (secondNumber == firstNumber);

        do {
            thirdNumber = Randoms.pickNumberInRange(1, 9);
        } while (thirdNumber == firstNumber || thirdNumber == secondNumber);

        String randomNumber = Integer.toString(firstNumber) + Integer.toString(secondNumber) + Integer.toString(thirdNumber);

        return randomNumber;
    }

    public static String getInputNumber() {
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        List<String> inputNumber = new ArrayList<String>(Arrays.asList(input.split("")));

        HashSet<String> checkDuplicate = new HashSet<String>(inputNumber);

        if (checkDuplicate.size() != inputNumber.size()) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static int[] compareValues(String randomNumber, String inputNumber) {
        char[] randomNumberArray = randomNumber.toCharArray();
        char[] inputNumberArray = inputNumber.toCharArray();

        int find = 0;
        int index = 0;
        int strike = 0;
        int ball = 0;

        for (int k = 0; k < 3; k++) {
            if (inputNumberArray[k] == randomNumberArray[0]) {
                index = 0;
                find = 1;
            }
            if (inputNumberArray[k] == randomNumberArray[1]) {
                index = 1;
                find = 1;
            }
            if (inputNumberArray[k] == randomNumberArray[2]) {
                index = 2;
                find = 1;
            }

            if (find == 1 && index == k) {
                strike += 1;
                find = 0;
            } else if (find == 1) {
                ball += 1;
                find = 0;
            }
        }
        if (strike + ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }

        int[] result = {strike, ball};

        return result;
    }

    public static void main(String[] args) {
        int[] compareValues = new int[2];
        while (true) {
            String randomNumber = getRandomNumber();
            System.out.println(randomNumber);
            while (compareValues[0] != 3) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = getInputNumber();
                compareValues = compareValues(randomNumber, inputNumber);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameStart = Console.readLine();
            if (gameStart.equals("1")) {
                compareValues = new int[2];
            } else if (gameStart.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
