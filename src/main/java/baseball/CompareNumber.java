package baseball;

import java.util.List;

public class CompareNumber {
    private boolean gameOver;

    public void compareNumber(Player player, Computer computer) {
        List<Integer> randomNumber = computer.getRandomNumber();
        player.playerInputNumber(); // 숫자 입력
        List<Integer> playerNumber = player.getInputNumber();

        int strike = calculateStrikes(randomNumber, playerNumber);
        int ball = calculateBalls(randomNumber, playerNumber);

        // 결과 출력
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        // 3 스트라이크인 경우 게임 종료
        if (strike == 3) {
            printGameOverMessage();
            gameOver = true;
        } else {
            gameOver = false;
        }
    }

    private int calculateStrikes(List<Integer> randomNumber, List<Integer> playerNumber) {
        int strike = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            if (randomNumber.get(i).equals(playerNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBalls(List<Integer> randomNumber, List<Integer> playerNumber) {
        int ball = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            if (randomNumber.contains(playerNumber.get(i)) && !randomNumber.get(i).equals(playerNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
