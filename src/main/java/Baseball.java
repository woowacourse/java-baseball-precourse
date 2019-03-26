import java.util.Arrays;
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

            if(num<111 || 999<num) {        /* minimum Value-verification. */
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

    /* match key with number. */
    public static boolean matchKey(int key, int num) {
        Integer[] keyArr = new Integer[3];
        Integer[] numArr = new Integer[3];
        int strike = 0;
        int ball = 0;
        boolean result = false;

        getDigit(key, keyArr);
        getDigit(num, numArr);

        for(int i=0; i<3; i++) {
            if(keyArr[i] == numArr[i]) {
                strike++;
            }
        }

        for(int i=0; i<3; i++) {
            if(Arrays.asList(keyArr).contains(numArr[i])) {
                ball++;
            }
        }
        ball -= strike;

        if(strike==0 && ball==0) {
            System.out.println("낫싱");
        } else if(strike>0 && ball>0) {
            System.out.println(strike+" 스트라이크 "+ball+"볼");
        } else if(ball>0) {
            System.out.println(ball+"볼");
        } else if(strike>0) {
            System.out.println(strike+" 스트라이크");
            if(strike == 3) {
                result = true;
            }
        }

        return result;
    }

    public static void getDigit(int number, Integer[] numberArr) {
        numberArr[0] = number / 100;
        numberArr[1] = (number / 10) % 10;
        numberArr[2] = number % 10;
    }
}
