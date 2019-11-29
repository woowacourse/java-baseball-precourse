/*
 *  @BaseballGame.java
 *
 *  컴퓨터와 플레이어를 생성한다
 *  플레이어가 입력한 숫자의 힌트를 제공한다
 *  정답일 때 다시 시작할 지, 종료할지 묻는다
 *
 *  @Version: 0.2
 *
 *  @Date: 2019.11.29
 *
 *  @Author: pandahun
 */
package baseballGame;

import java.util.Scanner;

public class BaseballGame {

    private static final String CONTINUE = "1";
    private static final String STOP = "2";
    private static final int ZERO = 0;

    public static final int BASEBALL_LENGTH = 3;

    private Computer computer;

    private Player player = new Player();

    public void run() {
        System.out.println("START THE GAME");
        while (true) {
            initialSetting();
            playGame();
            if (isStop()) {
                System.out.println("END THE GAME");
                break;
            }
        }
    }

    private void initialSetting() {
        setComputer();
    }

    private void setComputer() {
        computer = new Computer();
    }

    private void playGame() {
        while (true) {
            player.requestNumber();
            if (isAnswer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다!! 게임 종료");
                break;
            }
            makeHint();
        }
    }

    private boolean isAnswer() {
        boolean status = false;
        if (player.getNumber().equals(computer.getNumber())) {
            status = true;
        }
        return status;
    }

    private void makeHint() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (isStrike(i)) {
                strikeCount++;
            } else if (isBall(i)) {
                ballCount++;
            }
        }
        printHint(strikeCount, ballCount);
    }

    private boolean isStrike( int index ) {
        return (player.getNumber().charAt(index) == computer.getNumber().charAt(index));
    }

    private boolean isBall( int index ) {
        return (player.getNumber().contains(String.valueOf(computer.getNumber().charAt(index))));
    }

    private void printHint( int strikeCount, int ballCount ) {
        String result = "";
        if (strikeCount != ZERO) {
            result += strikeCount + " 스트라이크 ";
        }
        if (ballCount != ZERO) {
            result += ballCount + " 볼 ";
        }
        if (result.length() == ZERO) {
            result = "낫싱";
        }
        System.out.println(result);
    }

    private boolean isStop() {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            input = sc.next();
            if (!input.equals(STOP) && !input.equals(CONTINUE)) {
                System.out.println("입력이 잘못 되었습니다. 다시 입력해주세요");
                continue;
            }
            break;
        }
        return input.equals(STOP);
    }
}
