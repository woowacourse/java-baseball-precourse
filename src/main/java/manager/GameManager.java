package manager;

import agent.Opponent;
import agent.Player;

import java.util.Scanner;

public class GameManager {
    public static void play(Player player, Opponent opponent) {
        boolean correctFlag = false;
        opponent.generateAnswer();
        do {
            player.setUserInput();
            correctFlag = opponent.validate(player.getUserInput());
        } while(!correctFlag);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void main(String[] args) {
        Player player = new Player();
        Opponent opponent = new Opponent();
        Scanner scanner = new Scanner(System.in);
        int newOrQuit = 1;
        do {
            play(player, opponent);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newOrQuit = scanner.nextInt();
        } while(newOrQuit != 2);
    }
}
