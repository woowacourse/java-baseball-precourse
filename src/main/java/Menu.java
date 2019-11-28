import java.util.Scanner;

public class Menu {
    public void menu() {
        char selected;
        do {
            selected = menuUI();
        } while (!(selected == '2'));
    }

    public char menuUI() {
        System.out.println("!! 숫자 야구 게임 !!");
        System.out.println();
        System.out.println("1. 게임 시작");
        System.out.println("2. 종료");
        char selected = new Scanner(System.in).next().charAt(0);

        if (selected == '1') {
            Play game = new Play();
            String result = "";
            do {
                result = game.info(game.compare(game.guessNum()));
                System.out.println(result);
            } while (result.length() < 25);
        }
        else if (selected == '2') {
            System.out.println("게임 종료...");
        }
        else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return selected;
    }
}
