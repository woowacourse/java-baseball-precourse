package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private String computerNumber;

    Game(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static String getRandomValue() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() != 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!sb.toString().contains(randomNumber)) {
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

    public boolean checkNumber(String check) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) == check.charAt(i)) {
                strike++;
                continue;
            }
            if (computerNumber.contains(check.charAt(i) + "")) {
                ball++;
            }
        }
        printResult(ball, strike);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    public static void printResult(int ball, int strike) {
        StringBuilder result = new StringBuilder();


        if (ball != 0) {
            result.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            result.append(strike).append("스트라이크");
        }
        if (result.length() == 0) {
            result.append("낫싱");
        }
        if (strike == 3) {
            result.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        System.out.println(result);
    }
}