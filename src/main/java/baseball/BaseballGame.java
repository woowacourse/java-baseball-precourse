package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private int[] enemyNum;
    private int[] playerNum;

    public BaseballGame() {
        enemyNum = new int[3];
        playerNum = new int[3];
        setEnemyNum();
    }

    public void gameStart() {
        takePlayerNum();
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

    private void setEnemyNum() {
        int smallNumberIndex = 1;
        for (int i = 0; i < 3; i++) {
            enemyNum[i] = Randoms.pickNumberInRange(1, 9 - i);
        }
        if (enemyNum[0] <= enemyNum[1]) {
            enemyNum[1] += 1;
            smallNumberIndex = 0;
        }
        if (enemyNum[smallNumberIndex] <= enemyNum[2]) {
            enemyNum[2] += 1;
            if (smallNumberIndex == 1) {
                smallNumberIndex = 0;
            } else {
                smallNumberIndex = 1;
            }
        }
        if (enemyNum[smallNumberIndex] <= enemyNum[2]) {
            enemyNum[2] += 1;
        }
    }
}