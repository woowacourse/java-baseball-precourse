import java.util.Scanner;

/*
 * Baseball Class
 * @version 1.0
 * @author ohsang seo
 */
public class Baseball {
    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        boolean restart = true;
        while (restart) {
            restart = baseballGame();
        }
    }

    public static boolean baseballGame() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        int num = 0;
        int nextGame = 0;
        boolean result = false;

        // generateKey()

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            num = sc.nextInt();
            if(matchKey(key, num)) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        nextGame = sc.nextInt();
        if(nextGame == 1) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public static boolean matchKey(int key, int num) {
        return true;
    }
}
