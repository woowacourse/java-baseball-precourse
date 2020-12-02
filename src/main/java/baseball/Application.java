package baseball;

import utils.RandomUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        startBaseBallGame(scanner);

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int select = scanner.nextInt();
            if (select == 1) {
                startBaseBallGame(scanner);
            } else if (select == 2) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void startBaseBallGame(Scanner scanner) {
        Set<Integer> correctSet = new HashSet<>();
        int[] correctValue = new int[3];
        int index = 0;

        while (correctSet.size() < 3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            if (!correctSet.contains(randomNumber)) {
                correctSet.add(randomNumber);
                correctValue[index++] = randomNumber;
            }
        }

        System.out.println(Arrays.toString(correctValue));

        boolean isFinish = false;
        while (!isFinish) {
            String input = inputNumber(scanner);
            checkInputLengthThree(input);

            Set<Integer> expectSet = new HashSet<>();
            int[] expectValue = changeInputToExpectValue(input, expectSet);
            isFinish = compareValue(correctSet, correctValue, expectSet, expectValue);
        }
    }

    private static boolean compareValue(Set<Integer> correctSet, int[] correctValue, Set<Integer> expectSet, int[] expectValue) {
        boolean result = false;
        expectSet.retainAll(correctSet);
        int strike = 0;
        int ball = expectSet.size();

        for (int i = 0; i < 3; i++) {
            if (expectValue[i] == correctValue[i]) {
                strike++;
                ball--;
            }
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            result = true;
        }

        return result;
    }

    private static int[] changeInputToExpectValue(String input, Set<Integer> expectSet) {
        int[] expectValue = new int[3];
        for (int i = 0; i < input.length(); i++) {
            int expectNumber = input.charAt(i) - '0';
            if (expectNumber <= 0 || expectNumber > 9 || expectSet.contains(expectNumber)) {
                throw new IllegalArgumentException();
            }
            expectSet.add(expectNumber);
            expectValue[i] = expectNumber;
        }
        return expectValue;
    }

    private static void checkInputLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static String inputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.next();
        return input;
    }

}
