package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Referee {
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

    public static boolean gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String result = Console.readLine();

        if (!result.equals("1") && !result.equals("2")) {
            throw new IllegalArgumentException("1 or 2 만 입력해주세요.");
        }

        if (result.equals("1")) {
            return false;
        }

        return true;
    }
}
