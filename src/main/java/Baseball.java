import java.util.Random;
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

        key = generateKey();

        /* receive input and match Number. */
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            num = sc.nextInt();

            if(num<111 || 999<num) { /* minimum Value-verification. */
                System.out.println("잘못 입력하셨습니다.");
                continue;
            }
            if(matchKey(key, num)) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        /* determine restart Game or not. */
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            nextGame = sc.nextInt();

            if(nextGame == 1) {
                result = true;
                break;
            } else if(nextGame == 2) {
                result = false;
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }

        return result;
    }

    /* get 3 random number between 1~9 with no duplication. */
    public static int generateKey() {
        Random rand = new Random();
        int r1, r2, r3;

        r1 = rand.nextInt(9) + 1;
        while (true) {
            r2 = rand.nextInt(9) + 1;
            if(r2 != r1) {
                break;
            }
        }
        while (true) {
            r3 = rand.nextInt(9) + 1;
            if(r3 != r1 && r3 != r2) {
                break;
            }
        }

        return r1*100 + r2*10 + r3;
    }

    public static boolean matchKey(int key, int num) {
        return true;
    }
}
