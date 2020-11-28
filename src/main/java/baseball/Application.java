package baseball;

import java.util.Scanner;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int GAME_START = 1;
    private static final int SHUTDOWN = 2;
    private static int gameStatus = GAME_START;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Player player = new Player();
        NumberBaseBall numberBaseBall = new NumberBaseBall();

        while (gameStatus == GAME_START) {
            numberBaseBall.setRandomNumbers(numberBaseBall.makeRandomNumbers(MIN_NUMBER, MAX_NUMBER));// 랜덤숫자 세팅
            System.out.println("randomNumbers: " + numberBaseBall.getRandomNumbers());
            gameStatus = playGame(player, numberBaseBall, scanner);
            if (gameStatus == SHUTDOWN)
                break;
        }
    }

    private static int playGame(Player player, NumberBaseBall numberBaseBall, Scanner scanner) {
        String playerInput = player.playerInputNumbers(scanner); // 사용자 입력
        String roundResult = numberBaseBall.makeHint(playerInput, numberBaseBall.getRandomNumbers()); // 게임 결과
        System.out.println(roundResult);
        if (roundResult.contains("3스트라이크")) {
            return player.playerInputMenu(scanner);
        }
        return playGame(player, numberBaseBall, scanner);
    }

}
