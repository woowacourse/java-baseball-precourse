/**
 * Game.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

public class Game {
    private static int digitNumber = 3;

    public void init() {
        int[] userInput, computerInput, strikeBall;
        Computer computer = new Computer();
        User user = new User();
        userInput = user.inputNumber(digitNumber);
        computerInput = computer.pickRandomNumbers(digitNumber);
        while (true) {
            strikeBall = countStrikeBall(userInput, computerInput);
            if (printHints(strikeBall)) break;
            userInput = user.inputNumber(digitNumber);
        }
    }

    private boolean printHints(int[] strikeBall) {
        if (strikeBall[0] != 0) {
            System.out.printf("%d스트라이크 ", strikeBall[0]);
        }
        if (strikeBall[1] != 0) {
            System.out.printf("%d볼", strikeBall[1]);
        }
        if (strikeBall[0] == 0 && strikeBall[1] == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();

        if (strikeBall[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private int[] countStrikeBall(int[] userNum, int[] computerNum) {
        int[] strikeBall = new int[]{0, 0};
        int[] userIndex = new int[10];
        int[] computerIndex = new int[10];
        for (int i = 0; i < userNum.length; i++) {
            userIndex[userNum[i]] = 1;
            computerIndex[computerNum[i]] = 1;
            if (userNum[i] == computerNum[i]) {
                strikeBall[0]++;
                continue;
            }
            if (userIndex[computerNum[i]] == 1) {
                strikeBall[1]++;
            }
            if (computerIndex[userNum[i]] == 1) {
                strikeBall[1]++;
            }

        }
        return strikeBall;
    }
}
