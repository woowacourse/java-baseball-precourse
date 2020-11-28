package baseball;

import java.util.Scanner;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int RESTART = 1;
    private static final int SHUTDOWN = 2;
    private static final int GAME_OVER = 3;
    private static final int START_GAME = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Player player = new Player();
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        // 게임 상태: 재시작 1, 완전종료 2, 게임종료 3
        int menu = RESTART;
        while (true) {
            // 랜덤숫자 세팅
            if (menu == RESTART) {
                numberBaseBall.setRandomNumber(numberBaseBall.makeRandomNumber(MIN_NUMBER, MAX_NUMBER));
                menu = START_GAME;
                System.out.println("randomNumbers: " + numberBaseBall.randomNumber);
            }
            // 사용자 입력
            String playerInput = player.playerInputNumber(scanner);
            // 게임 결과
            String roundResult = numberBaseBall.makeHint(playerInput, numberBaseBall.randomNumber);
            System.out.println(roundResult);
            if (roundResult.charAt(0) - '0' == GAME_OVER) {
                menu = player.playerInputMenu(scanner);
            }
            if (menu == SHUTDOWN)
                break;
        }
    }
}
