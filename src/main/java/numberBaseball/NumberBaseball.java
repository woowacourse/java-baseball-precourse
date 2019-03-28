package numberBaseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import numberBaseball.player.*;

public class NumberBaseball {
    private String gameMode = "메인 메뉴";
    private ArrayList<String> menu = new ArrayList<String>();

    public NumberBaseball() {
        setMenu();
    }

    public void setMenu() {
        this.menu.add("게임 실행");
        this.menu.add("게임 종료");
    }

    public String getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(String mode) {
        this.gameMode = mode;
    }

    public void showIntro() {
        System.out.println("우아한 숫자야구 게임에 오신것을 환영합니다!");
    }

    public void showMenu() {
        System.out.println("");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i + 1) + ". " + this.menu.get(i));
        }
        System.out.println("");
    }

    public String selectGameMode() {
        int selectedIdx;

        showMenu();
        System.out.print("어떤 동작을 할까요? ");
        while (true) {
            try {
                selectedIdx = (new Scanner(System.in)).nextInt() - 1;
                setGameMode(this.menu.get(selectedIdx));
                return getGameMode();
            } catch (IndexOutOfBoundsException e) {
                System.out.print("메뉴에 없는 번호입니다.\n올바른 번호를 입력해주세요 :");
            } catch (InputMismatchException e) {
                System.out.print("번호로 입력해주세요 : ");
            }
        }
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

        numberBaseball.showIntro();
        while (numberBaseball.selectGameMode() != "게임 종료") {
            numberBaseball.startGame(player, playerBot);
        }
    }
}