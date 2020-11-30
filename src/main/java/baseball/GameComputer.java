package baseball;

import java.util.Scanner;
import java.util.Arrays;
import utils.RandomUtils;

public class GameComputer {
    final Scanner scanner = new Scanner(System.in);
    BallChoice computerChoice;

    public GameComputer() {
        computerChoice = new BallChoice();
        computerChoice.choice = chooseChoice();

        isGameOver(false, computerChoice);
    }

    public static String chooseChoice() {
        String computerChoice;
        int[] answer = new int[BallChoice.CHOICE_SIZE];

        answer[0] = RandomUtils.nextInt(1,9);
        do {
            answer[1] = RandomUtils.nextInt(1,9);
        } while (answer[0] == answer[1]);
        do {
            answer[2] = RandomUtils.nextInt(1,9);
        } while (answer[0] == answer[2] || answer[1] == answer[2]);

        computerChoice = Arrays.toString(answer).replaceAll("[^0-9]","");
        return computerChoice;
    }

    static void isGameOver(boolean gameOver, BallChoice computerChoice) {
        while (!gameOver) {
            gameOver = GameComputer.startGame(computerChoice);
        }
    }

    static boolean startGame(BallChoice computerChoice) {
        GamePlayer player = new GamePlayer();

        player.chooseChoice();
        int strike = GameUmpire.umpirePitch(computerChoice, player.userChoice);
        
        if (strike == BallChoice.CHOICE_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }
}
