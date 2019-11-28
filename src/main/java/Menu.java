import javax.sound.sampled.Line;
import java.util.Scanner;

public class Menu {
    public void menu() {
        char selected = '0';

        while (!(selected == '2')) {
            System.out.println("!! 숫자 야구 게임 !!");
            System.out.println();
            System.out.println("1. 게임 시작");
            System.out.println("2. 종료");
            selected = new Scanner(System.in).next().charAt(0);

            if (selected == '1') {

            }
            else if (selected == '2') {
                System.out.println("게임 종료...");
            }
            else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
            System.out.println();
        }
    }
}
