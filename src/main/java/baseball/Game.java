package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final int DIGIT = 3;
    private String randNum;
    private String userNum;
    private int ball;
    private int strike;

    public void startGame() {
        while (true) {
            startRound();

            if (!restart()) {
                return;
            }
        }
    }

    private void startRound() {
        randNum = makeRandNum();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userNum = Console.readLine();
            isValidInput();
            String result = compareNumbs();
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    private String makeRandNum() {
        StringBuilder randNum = new StringBuilder();

        while (randNum.length() < DIGIT) {
            String temp = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!randNum.toString().contains(temp)) {
                randNum.append(temp);
            }
        }

        return String.valueOf(randNum);
    }

    private void isValidInput() {
        if (userNum.length() != DIGIT) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < DIGIT; i++) {
            inRange(i);
            noOverlap(i);
        }
    }

    private void inRange(int i) {
        if (userNum.charAt(i) < '1' || userNum.charAt(i) > '9') {
            throw new IllegalArgumentException();
        }
    }

    private void noOverlap(int i) {
        for (int j = i + 1; j < DIGIT; j++) {
            if (userNum.charAt(i) == userNum.charAt(j)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String compareNumbs() {
        ball = 0;
        strike = 0;

        for (int i = 0; i < DIGIT; i++) {
            parseNum(i, randNum.charAt(i));
        }

        return getHint();
    }

    private void parseNum(int i, char curNum) {
        if (userNum.contains(Character.toString(curNum))) {
            if (userNum.charAt(i) == curNum) {
                strike++;
                return;
            }
            ball++;
        }
    }

    private String getHint() {
        if (strike == 3) {
            return "3스트라이크";
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
