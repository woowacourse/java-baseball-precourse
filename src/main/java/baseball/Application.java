package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gameCoin = true;
        while (gameCoin) {
            GameComputer gameCom = new GameComputer();
            String computerChoice = gameCom.chooseChoice();
            boolean gameOver = false;
            while (!gameOver) {
                gameOver = GameComputer.startGame(computerChoice);
            }
            gameCoin = checkGameCoin();
        }
    }
    
    static boolean checkGameCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int gameCoin = sc.nextInt();
        ExceptionChecker.checkException(gameCoin);
        return gameCoin == 1;
    }

}
