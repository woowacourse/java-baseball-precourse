package numberBaseball;

import java.util.ArrayList;
import java.util.Scanner;
import numberBaseball.player.*;

public class NumberBaseball {
    private String gameMode = "메인 메뉴";
    private ArrayList<String> menu = new ArrayList<String>();

    public NumberBaseball() {
        setMenu();
    }

    public void setMenu() {
        this.menu.add("연습 모드");
        this.menu.add("대전 모드");
        this.menu.add("게임 종료");
    }

    public String getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(String mode) {
        this.gameMode = mode;
    }

    public void showMenu() {
        System.out.println("");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i + 1) + ". " + this.menu.get(i));
        }
        System.out.println("");
    }

    public void selectGameMode() {
        showMenu();
        System.out.print("어떤 모드로 게임하시겠어요? ");
        int selectedIdx = new Scanner(System.in).nextInt() - 1;
        setGameMode(this.menu.get(selectedIdx));
    }

    public void startGame(Player guesser, Player answerer) {
        int[] guessed;

        answerer.setThreeNumber();
        while (true) {
            guessed =  guesser.guessThreeNumber();
            answerer.answerHintOf(guessed);
            if (answerer.checkCorrect(guessed)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                setGameMode("메인 메뉴");
                return;
            }
        }
    }

    public static void main(String args[]) {
        NumberBaseball numberBaseball =  new NumberBaseball();
        Player player = new User();
        Player playerBot = new PlayerBot();

        while (numberBaseball.getGameMode() != "게임 종료") {
            numberBaseball.selectGameMode();
            numberBaseball.startGame(player, playerBot);
        }
    }
}