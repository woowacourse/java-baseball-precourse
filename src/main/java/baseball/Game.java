package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private static final int MAX_STRIKE = 3;
    private static final Computer computer = new Computer();
    private static final Player player = new Player();
    private boolean isGameEnd = false;
    private int strike = 0;
    private int ball = 0;

    public void start() {
        while (!isGameEnd) {
            initGame();
            while (strike != MAX_STRIKE) {
                player.initNumbers();
                checkComputerAndPlayer();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isGameEnd = isGameExit();
        }
    }

    private void initGame() {
        computer.shuffleNumbers();
        isGameEnd = false;
        strike = 0;
        ball = 0;
    }

    private void checkComputerAndPlayer() {
        strike = checkStrike(computer.getNumbers(), player.getNumbers());
        ball = checkBall(computer.getNumbers(), player.getNumbers());
        resultPrint();
    }

    private int checkStrike(List<Integer> computers, List<Integer> players) {
        int count = 0;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).equals(players.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int checkBall(List<Integer> computers, List<Integer> players) {
        int count = 0;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.contains(players.get(i)) && !computers.get(i).equals(players.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void resultPrint() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

    private boolean isGameExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exitStr = Console.readLine();
        checkGameExitStr(exitStr);
        return exitStr.equals("2");
    }

    private void checkGameExitStr(String str) {
        if (str.equals("1") || str.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
