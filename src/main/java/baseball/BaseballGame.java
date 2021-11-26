package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.IntStream;

public class BaseballGame {
    private int[] enemyNum;
    private int[] playerNum;

    public BaseballGame() {
        initializeNums();
    }

    private void initializeNums() {
        enemyNum = new int[3];
        playerNum = new int[3];
    }

    private void setEnemyNum() {
        int i = 0;
        int temp;
        while (i < 3) {
            temp = Randoms.pickNumberInRange(1, 9);
            int finalTemp = temp;
            if (!IntStream.of(enemyNum).anyMatch(x -> finalTemp == x)) {
                enemyNum[i] = temp;
                i++;
            }
        }
    }

    public void gameStart() {
        initializeNums();
        setEnemyNum();
        do {
            takePlayerNum();
        } while (!checkResult());
    }

    private void takePlayerNum() {
        char charPlayerNum;
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            charPlayerNum = userInput.charAt(i);
            if (!Character.isDigit(charPlayerNum)) {
                throw new IllegalArgumentException();
            }
            playerNum[i] = Character.getNumericValue(charPlayerNum);
        }
    }

    private boolean checkResult() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNum[i] == enemyNum[i]) {
                strike++;
                playerNum[i] = -1;
            }
        }
        for (Integer num : playerNum) {
            if (IntStream.of(enemyNum).anyMatch(x -> x == num)) {
                ball++;
            }
        }
        return printResult(strike, ball);
    }

    private boolean printResult(int strike, int ball) {
        if (ball != 0) {
            System.out.print(String.format("%d볼", ball));
        }
        if (ball != 0 && strike != 0) {
            System.out.print(" ");
        }
        if (strike != 0) {
            System.out.print(String.format("%d스트라이크", strike));
        }
        if (ball + strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println("");
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public boolean decideToRestart() {
        String stringRestartValue;
        char charRestartValue;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        stringRestartValue = Console.readLine();
        if (stringRestartValue.length() != 1) {
            throw new IllegalArgumentException();
        }
        charRestartValue = stringRestartValue.charAt(0);
        if (charRestartValue == '1') {
            return true;
        } else if (charRestartValue == '2') {
            System.out.println("게임 종료");
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
